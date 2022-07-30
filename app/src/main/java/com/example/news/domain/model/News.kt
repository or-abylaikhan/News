package com.example.news.domain.model

import com.example.news.data.network.model.ArticleResponse

data class News(
    val status: String,
    val totalResults: Int,
    val articleData: List<ArticleResponse>
)