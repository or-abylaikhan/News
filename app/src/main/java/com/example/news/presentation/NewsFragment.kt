package com.example.news.presentation

import com.example.news.databinding.FragmentNewsBinding
import com.example.news.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BindingFragment<FragmentNewsBinding>(FragmentNewsBinding::inflate) {}