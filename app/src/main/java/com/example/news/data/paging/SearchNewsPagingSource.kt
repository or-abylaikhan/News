package com.example.news.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.news.data.mapper.ArticleResponseMapper
import com.example.news.data.network.NewsApi
import com.example.news.domain.model.Article
import com.example.news.util.Constants.NEWS_STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class SearchNewsPagingSource(
    private val api: NewsApi,
    private val articleResponseMapper: ArticleResponseMapper,
    private val query: String
) : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val position = params.key ?: NEWS_STARTING_PAGE_INDEX
        return try {
            val response = api.searchForNews(query, position)
            val articles = articleResponseMapper.to(response.body()?.articleData ?: emptyList())
            LoadResult.Page(
                data = articles,
                prevKey = if (position == NEWS_STARTING_PAGE_INDEX) null else position.minus(1),
                nextKey = if (articles.isEmpty()) null else position.plus(1)
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>) = NEWS_STARTING_PAGE_INDEX
}