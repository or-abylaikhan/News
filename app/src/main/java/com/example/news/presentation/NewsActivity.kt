package com.example.news.presentation

import android.os.Bundle
import com.example.news.databinding.ActivityNewsBinding
import com.example.news.util.binding.BindingActivity

class NewsActivity : BindingActivity<ActivityNewsBinding>(ActivityNewsBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}