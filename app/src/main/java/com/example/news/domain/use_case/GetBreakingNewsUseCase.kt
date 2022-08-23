package com.example.news.domain.use_case

import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class GetBreakingNewsUseCase @Inject constructor(private val articleRepository: ArticleRepository) {
    fun getBreakingNews(countryCode: String) = articleRepository.getBreakingNews(countryCode)
}