package com.example.news.util

import android.text.format.DateUtils
import com.example.news.R
import com.example.news.domain.model.Article
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import java.text.SimpleDateFormat
import java.util.*

fun ChipGroup.addChip(text: String) = apply {
    val chip = Chip(context)
    chip.text = text
    val drawable = ChipDrawable.createFromAttributes(context, null, 0, R.style.CustomChipStyle)
    chip.setChipDrawable(drawable)
    addView(chip)
}

//Model extensions
fun Article.publishedAtSimple(locale: Locale = Locale.getDefault()): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", locale)
    val parsedDate: Date = inputFormat.parse(publishedAt) as Date
    val timeInMillis = Calendar.getInstance().timeInMillis
    val minuteInMillis = DateUtils.MINUTE_IN_MILLIS
    return "${DateUtils.getRelativeTimeSpanString(parsedDate.time, timeInMillis, minuteInMillis)}"
}