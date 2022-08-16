package com.example.news.domain.repository

import androidx.lifecycle.LiveData
import com.example.news.domain.model.Article
import com.example.news.util.Resource

interface ArticleRepository {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Resource<List<Article>>

    suspend fun searchForNews(searchQuery: String, pageNumber: Int): Resource<List<Article>>

    suspend fun saveArticle(article: Article)

    fun getSavedArticles(): LiveData<List<Article>>

    suspend fun deleteArticle(article: Article)

    fun checkIfAlreadyExists(url: String): LiveData<Boolean>
}