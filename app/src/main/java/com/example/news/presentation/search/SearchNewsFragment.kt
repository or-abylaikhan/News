package com.example.news.presentation.search

import com.example.news.databinding.FragmentSearchNewsBinding
import com.example.news.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchNewsFragment :
    BindingFragment<FragmentSearchNewsBinding>(FragmentSearchNewsBinding::inflate)