package com.example.news.data.repository

import androidx.lifecycle.Transformations
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.news.data.database.ArticleDao
import com.example.news.data.mapper.ArticleEntityMapper
import com.example.news.data.mapper.ArticleResponseMapper
import com.example.news.data.network.NewsApi
import com.example.news.data.paging.BreakingNewsPagingSource
import com.example.news.data.paging.SearchNewsPagingSource
import com.example.news.domain.model.Article
import com.example.news.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val articleDao: ArticleDao,
    private val responseMapper: ArticleResponseMapper,
    private val articleEntityMapper: ArticleEntityMapper
) : ArticleRepository {

    override fun getBreakingNews(countryCode: String) =
        Pager(config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = { BreakingNewsPagingSource(api, responseMapper, countryCode) }
        ).liveData

    override fun searchForNews(searchQuery: String) =
        Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory = { SearchNewsPagingSource(api, responseMapper, searchQuery) }
        ).liveData

    override suspend fun saveArticle(article: Article) =
        articleDao.insert(articleEntityMapper.from(article))

    override fun getSavedArticles() =
        Transformations.map(articleDao.selectAll(), articleEntityMapper::to)

    override suspend fun deleteArticle(article: Article) =
        articleDao.delete(articleEntityMapper.from(article))

    override fun checkIfAlreadyExists(url: String) = articleDao.alreadyExists(url)
}