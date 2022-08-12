package com.example.news.presentation.saved

import com.example.news.databinding.FragmentSavedNewsBinding
import com.example.news.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedNewsFragment :
    BindingFragment<FragmentSavedNewsBinding>(FragmentSavedNewsBinding::inflate)