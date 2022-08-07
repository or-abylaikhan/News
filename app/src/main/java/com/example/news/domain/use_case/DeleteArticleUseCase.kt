package com.example.news.domain.use_case

import com.example.news.domain.model.Article
import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class DeleteArticleUseCase @Inject constructor(private val articleRepository: ArticleRepository) {
    suspend fun deleteArticle(article: Article) = articleRepository.deleteArticle(article)
}