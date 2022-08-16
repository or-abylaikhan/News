package com.example.news.presentation.article

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import com.example.news.databinding.FragmentArticleBinding
import com.example.news.domain.model.Article
import com.example.news.util.Constants.ARTICLE
import com.example.news.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : BindingFragment<FragmentArticleBinding>(FragmentArticleBinding::inflate) {

    private val viewModel: ArticleFragmentViewModel by viewModels()
    private lateinit var article: Article
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        article = arguments?.getSerializable(ARTICLE) as Article
        iniViews()
        setupListeners()
        setupObservers()
    }

    private fun setupListeners() = binding.fab.setOnClickListener { viewModel.save(article) }

    private fun iniViews() =
        binding.wv.apply { webViewClient = WebViewClient(); loadUrl(article.url) }

    private fun setupObservers() {
        viewModel.checkIfAlreadyExists(article.url).observe(viewLifecycleOwner) { alreadyExists ->
            with(binding) { if (alreadyExists) fab.hide() else fab.show() }
        }
    }
}