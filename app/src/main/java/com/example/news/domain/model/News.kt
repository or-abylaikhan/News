package com.example.news.domain.model

data class News(
    val status: String,
    val totalResults: Int,
    val articleData: List<Article>
)