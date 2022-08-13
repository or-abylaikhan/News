package com.example.news.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.news.data.database.ArticleDao
import com.example.news.data.mapper.ArticleEntityMapper
import com.example.news.data.mapper.ArticleResponseMapper
import com.example.news.data.network.NewsApi
import com.example.news.domain.model.Article
import com.example.news.domain.repository.ArticleRepository
import com.example.news.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val articleDao: ArticleDao,
    private val articleResponseMapper: ArticleResponseMapper,
    private val articleEntityMapper: ArticleEntityMapper
) : ArticleRepository {

    override suspend fun getBreakingNews(
        countryCode: String,
        pageNumber: Int
    ): Resource<List<Article>> = withContext(Dispatchers.IO) {
        try {
            val response = api.getBreakingNews(countryCode, pageNumber)
            if (response.isSuccessful) {
                val articleData =
                    articleResponseMapper.to(response.body()?.articleData ?: emptyList())
                Resource.Success(data = articleData)
            } else {
                Resource.Error(errorMessage = response.errorBody().toString())
            }
        } catch (e: HttpException) {
            Resource.Error(errorMessage = e.message ?: "Something went wrong")
        } catch (e: IOException) {
            Resource.Error("Please check your network connection")
        }
    }

    override suspend fun searchForNews(
        searchQuery: String,
        pageNumber: Int
    ): Resource<List<Article>> = withContext(Dispatchers.IO) {
        try {
            val response = api.searchForNews(searchQuery, pageNumber)
            if (response.isSuccessful) {
                val articleData =
                    articleResponseMapper.to(response.body()?.articleData ?: emptyList())
                Resource.Success(data = articleData)
            } else {
                Resource.Error(errorMessage = response.errorBody().toString())
            }
        } catch (e: HttpException) {
            Resource.Error(errorMessage = e.message ?: "Something went wrong")
        } catch (e: IOException) {
            Resource.Error("Please check your network connection")
        }
    }

    override fun getSavedArticles(): LiveData<List<Article>> =
        Transformations.map(articleDao.selectAll()) { articleEntityMapper.to(it) }

    override suspend fun saveArticle(article: Article) =
        articleDao.insert(articleEntityMapper.from(article))

    override suspend fun deleteArticle(article: Article) =
        articleDao.delete(articleEntityMapper.from(article))
}