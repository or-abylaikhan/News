package com.example.news.domain.use_case

import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class GetSavedArticlesUseCase @Inject constructor(private val articleRepository: ArticleRepository) {
    fun getSavedArticles() = articleRepository.getSavedArticles()
}