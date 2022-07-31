package com.example.news.util

import android.annotation.SuppressLint
import com.example.news.domain.model.Article
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun Article.publishedAtSimple(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val outputFormat = SimpleDateFormat("yyyy-MM-dd hh:mm a")
    val parsedDate: Date = inputFormat.parse(this.publishedAt) as Date
    return outputFormat.format(parsedDate)
}