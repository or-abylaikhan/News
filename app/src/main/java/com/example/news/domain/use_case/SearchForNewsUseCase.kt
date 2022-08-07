package com.example.news.domain.use_case

import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class SearchForNewsUseCase @Inject constructor(private val articleRepository: ArticleRepository) {
    suspend fun searchForNews(countryCode: String, pageNumber: Int) =
        articleRepository.searchForNews(countryCode, pageNumber)
}