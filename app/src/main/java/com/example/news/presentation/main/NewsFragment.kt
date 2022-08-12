package com.example.news.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.news.databinding.FragmentNewsBinding
import com.example.news.presentation.NewsAdapter
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
        binding.rvNews.adapter = NewsAdapter(OnItemClickListener = {})
    }

    private fun setupObservers() {
        with(binding) {
            viewModel.breakingNews.observe(viewLifecycleOwner) { resource ->
                when (resource) {
                    is Resource.Loading -> pb.makeVisible()
                    is Resource.Success -> {
                        (rvNews.adapter as NewsAdapter).submitList(resource.data)
                        pb.makeGone()
                    }
                    is Resource.Error ->
                        Toast.makeText(context, resource.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}