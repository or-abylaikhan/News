package com.example.news.presentation.article

import com.example.news.databinding.FragmentArticleBinding
import com.example.news.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : BindingFragment<FragmentArticleBinding>(FragmentArticleBinding::inflate) {}