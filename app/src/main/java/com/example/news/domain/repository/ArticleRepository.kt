package com.example.news.domain.repository

import androidx.lifecycle.LiveData
import com.example.news.domain.model.Article

interface ArticleRepository {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): List<Article>

    suspend fun searchForNews(searchQuery: String, pageNumber: Int): List<Article>

    suspend fun saveArticle(article: Article)

    fun getSavedArticles(): LiveData<List<Article>>

    suspend fun deleteArticle(article: Article)
}