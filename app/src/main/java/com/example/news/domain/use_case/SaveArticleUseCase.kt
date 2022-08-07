package com.example.news.domain.use_case

import com.example.news.domain.model.Article
import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class SaveArticleUseCase @Inject constructor(private val articleRepository: ArticleRepository) {
    suspend fun saveArticle(article: Article) = articleRepository.saveArticle(article)
}