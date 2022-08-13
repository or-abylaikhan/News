package com.example.news.presentation.saved

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.news.R
import com.example.news.databinding.FragmentSavedNewsBinding
import com.example.news.presentation.NewsAdapter
import com.example.news.util.Constants
import com.example.news.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedNewsFragment :
    BindingFragment<FragmentSavedNewsBinding>(FragmentSavedNewsBinding::inflate) {

    private val viewModel: SaveNewsFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniViews()
        setupObservers()
    }

    private fun iniViews() {
        binding.rvNews.adapter = NewsAdapter(
            OnItemClickListener = {
                val bundle = bundleOf(Constants.ARTICLE to it)
                findNavController().navigate(
                    R.id.action_savedNewsFragment_to_articleFragment, bundle
                )
            }
        )
    }

    private fun setupObservers() = viewModel.getSavedArticles().observe(viewLifecycleOwner) {
        with(binding) {
            (rvNews.adapter as NewsAdapter).submitList(it)
        }
    }
}