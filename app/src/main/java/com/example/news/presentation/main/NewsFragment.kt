package com.example.news.presentation.main

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.news.R
import com.example.news.databinding.FragmentNewsBinding
import com.example.news.presentation.adapter.ArticlePagingAdapter
import com.example.news.util.Constants.ARTICLE
import com.example.news.util.addChip
import com.example.news.util.binding.BindingFragment
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BindingFragment<FragmentNewsBinding>(FragmentNewsBinding::inflate) {

    private val viewModel: NewsFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        setupListeners()
        setupObservers()
    }

    private fun initViews() = with(binding) {
        val countryCodes = resources.getStringArray(R.array.country_codes)
        countryCodes.forEach { chips.addChip(it) }
        rvNews.adapter = ArticlePagingAdapter(
            OnItemClickListener = {
                val bundle = bundleOf(ARTICLE to it)
                findNavController().navigate(R.id.action_newsFragment_to_articleFragment, bundle)
            }
        )
    }

    private fun setupListeners() = with(binding) {
        chips.setOnCheckedStateChangeListener { _, checkedId ->
            val countryCode = (chips.getChildAt(checkedId.first() - 1) as Chip).text.toString()
            viewModel.changeCountry(countryCode)
        }
    }

    private fun setupObservers() = with(binding) {
        viewModel.breakingNews.observe(viewLifecycleOwner) {
            (rvNews.adapter as ArticlePagingAdapter).submitData(viewLifecycleOwner.lifecycle, it)
        }
    }
}