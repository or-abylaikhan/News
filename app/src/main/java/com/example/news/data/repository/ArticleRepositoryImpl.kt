package com.example.news.data.repository

import androidx.lifecycle.LiveData
import com.example.news.data.database.ArticleDao
import com.example.news.data.network.NewsApi
import com.example.news.domain.model.Article
import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val articleDao: ArticleDao
) : ArticleRepository {

    override suspend fun getBreakingNews(countryCode: String, pageNumber: Int): List<Article> {
        TODO("Not yet implemented")
    }

    override suspend fun searchForNews(searchQuery: String, pageNumber: Int): List<Article> {
        TODO("Not yet implemented")
    }

    override suspend fun saveArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedArticles(): LiveData<List<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteArticle(article: Article) {
        TODO("Not yet implemented")
    }
}