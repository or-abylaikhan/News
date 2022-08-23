package com.example.news.util

import android.os.Build
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.annotation.RequiresApi
import com.example.news.R
import com.example.news.domain.model.Article
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
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
@RequiresApi(Build.VERSION_CODES.O)
fun Article.publishedAtSimple(locale: Locale = Locale.getDefault()): String {
    val inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", locale)
    val parsedDate: LocalDate = LocalDate.parse(publishedAt, inputFormat)
    return Period.between(parsedDate, LocalDate.now()).toString()
}