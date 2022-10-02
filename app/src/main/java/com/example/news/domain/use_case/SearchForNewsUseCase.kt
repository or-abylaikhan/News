package com.example.news.domain.use_case

import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class SearchForNewsUseCase @Inject constructor(private val articleRepository: ArticleRepository) {
    fun searchForNews(searchQuery: String) = articleRepository.searchForNews(searchQuery)
}