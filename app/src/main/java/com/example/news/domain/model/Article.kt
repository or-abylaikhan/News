package com.example.news.domain.model

import com.example.news.data.network.model.SourceResponse

data class Article(
    val sourceResponse: SourceResponse,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)