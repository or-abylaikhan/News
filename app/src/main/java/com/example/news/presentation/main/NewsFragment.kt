package com.example.news.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.news.R
import com.example.news.databinding.FragmentNewsBinding
import com.example.news.presentation.adapter.ArticleAdapter
import com.example.news.util.Constants.ARTICLE
import com.example.news.util.Resource
import com.example.news.util.binding.BindingFragment
import com.example.news.util.makeGone
import com.example.news.util.makeVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BindingFragment<FragmentNewsBinding>(FragmentNewsBinding::inflate) {

    private val viewModel: NewsFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setupObservers()
    }

    private fun initViews() {
        binding.rvNews.adapter = ArticleAdapter(
            OnItemClickListener = {
                val bundle = bundleOf(ARTICLE to it)
                findNavController().navigate(R.id.action_newsFragment_to_articleFragment, bundle)
            }
        )
    }

    private fun setupObservers() {
        with(binding) {
            viewModel.breakingNews.observe(viewLifecycleOwner) { resource ->
                when (resource) {
                    is Resource.Loading -> pb.makeVisible()
                    is Resource.Success -> {
                        (rvNews.adapter as ArticleAdapter).submitList(resource.data)
                        pb.makeGone()
                    }
                    is Resource.Error ->
                        Toast.makeText(context, resource.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}