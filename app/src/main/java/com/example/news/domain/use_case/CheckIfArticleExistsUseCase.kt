package com.example.news.domain.use_case

import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class CheckIfArticleExistsUseCase @Inject constructor(private val articleRepository: ArticleRepository) {
    fun checkIfAlreadyExists(url: String) = articleRepository.checkIfAlreadyExists(url)
}