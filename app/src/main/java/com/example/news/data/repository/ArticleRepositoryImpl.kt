package com.example.news.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.news.data.database.ArticleDao
import com.example.news.data.mapper.ArticleEntityMapper
import com.example.news.data.mapper.ArticleResponseMapper
import com.example.news.data.network.NewsApi
import com.example.news.domain.model.Article
import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val articleDao: ArticleDao,
    private val articleResponseMapper: ArticleResponseMapper,
    private val articleEntityMapper: ArticleEntityMapper
) : ArticleRepository {

    override suspend fun getBreakingNews(countryCode: String, pageNumber: Int): List<Article> {
        TODO("Not yet implemented")
    }

    override suspend fun searchForNews(searchQuery: String, pageNumber: Int): List<Article> {
        TODO("Not yet implemented")
    }

    override fun getSavedArticles(): LiveData<List<Article>> =
        Transformations.map(articleDao.selectAll()) { articleEntityMapper.to(it) }

    override suspend fun saveArticle(article: Article) =
        articleDao.insert(articleEntityMapper.from(article))

    override suspend fun deleteArticle(article: Article) =
        articleDao.delete(articleEntityMapper.from(article))
}