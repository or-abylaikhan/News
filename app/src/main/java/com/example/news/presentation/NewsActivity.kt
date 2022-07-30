package com.example.news.presentation

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.news.R
import com.example.news.databinding.ActivityNewsBinding
import com.example.news.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsActivity : BindingActivity<ActivityNewsBinding>(ActivityNewsBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                ?.let { navHostFragment ->
                    bottomNav.setupWithNavController(navHostFragment.findNavController())
                }
        }
    }
}