package com.example.news.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.news.databinding.FragmentNewsBinding
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
        viewModel.breakingNews.observe(viewLifecycleOwner) { resource ->
            with(binding) {
                when (resource) {
                    is Resource.Loading -> binding.pb.makeVisible()
                    is Resource.Success -> {
                        pb.makeGone()
                        (rvNews.adapter as NewsAdapter).submitList(resource.data)
                    }
                    is Resource.Error -> {
                        Toast.makeText(context, resource.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}