package com.example.news.util

import android.annotation.SuppressLint
import android.text.format.DateUtils
import android.view.View
import com.example.news.domain.model.Article
import java.text.SimpleDateFormat
import java.util.*

// View extensions
fun View.makeGone() {
    this.visibility = View.GONE
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

//Model extensions
@SuppressLint("SimpleDateFormat")
fun Article.publishedAtSimple(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val parsedDate: Date = inputFormat.parse(publishedAt) as Date
    return DateUtils.getRelativeTimeSpanString(
        parsedDate.time, Calendar.getInstance().timeInMillis, DateUtils.MINUTE_IN_MILLIS
    ).toString()
}