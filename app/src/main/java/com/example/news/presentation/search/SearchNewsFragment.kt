package com.example.news.presentation.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.news.R
import com.example.news.databinding.FragmentSearchNewsBinding
import com.example.news.presentation.adapter.ArticlePagingAdapter
import com.example.news.util.Constants
import com.example.news.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchNewsFragment :
    BindingFragment<FragmentSearchNewsBinding>(FragmentSearchNewsBinding::inflate) {

    private val viewModel: SearchNewsFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setupListeners()
        setupObservers()
    }

    private fun initViews() {
        binding.rvNews.adapter = ArticlePagingAdapter(
            OnItemClickListener = {
                val bundle = bundleOf(Constants.ARTICLE to it)
                findNavController().navigate(
                    R.id.action_searchNewsFragment_to_articleFragment, bundle
                )
            }
        )
    }


    private fun setupListeners() {
        binding.sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return if (!query.isNullOrEmpty()) {
                    viewModel.searchArticles(query)
                    true
                } else
                    false
            }

            override fun onQueryTextChange(newText: String?) = true
        })
    }

    private fun setupObservers() {
        with(binding) {
            viewModel.articles.observe(viewLifecycleOwner) {
                (rvNews.adapter as ArticlePagingAdapter).submitData(
                    viewLifecycleOwner.lifecycle,
                    it
                )
            }
        }
    }
}