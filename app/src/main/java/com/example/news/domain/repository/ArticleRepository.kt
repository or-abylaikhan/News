package com.example.news.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.news.domain.model.Article

interface ArticleRepository {

    fun getBreakingNews(countryCode: String): LiveData<PagingData<Article>>

    fun searchForNews(searchQuery: String): LiveData<PagingData<Article>>

    suspend fun saveArticle(article: Article)

    fun getSavedArticles(): LiveData<List<Article>>

    suspend fun deleteArticle(article: Article)

    fun checkIfAlreadyExists(url: String): LiveData<Boolean>
}