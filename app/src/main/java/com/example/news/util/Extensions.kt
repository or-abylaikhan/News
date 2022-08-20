package com.example.news.util

import android.text.format.DateUtils
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.news.R
import com.example.news.domain.model.Article
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import java.text.SimpleDateFormat
import java.util.*

// View extensions
fun View.makeGone() = apply { visibility = GONE }

fun View.makeVisible() = apply { visibility = VISIBLE }

fun ChipGroup.addChip(text: String) = apply {
    val chip = Chip(context)
    chip.text = text
    val drawable = ChipDrawable.createFromAttributes(context, null, 0, R.style.CustomChipStyle)
    chip.setChipDrawable(drawable)
    addView(chip)
}

//Model extensions
fun Article.publishedAtSimple(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val parsedDate: Date = inputFormat.parse(publishedAt) as Date
    val timeInMillis = Calendar.getInstance().timeInMillis
    val minuteInMillis = DateUtils.MINUTE_IN_MILLIS
    return "${DateUtils.getRelativeTimeSpanString(parsedDate.time, timeInMillis, minuteInMillis)}"
}