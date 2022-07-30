package com.example.news.data.network

import com.example.news.data.network.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1
    ): Response<NewsResponse>

    @GET("/v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1
    ): Response<NewsResponse>

}