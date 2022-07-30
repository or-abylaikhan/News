package com.example.news.data.database

import androidx.room.TypeConverter
import com.example.news.data.database.model.SourceEntity

class Converters {

    @TypeConverter
    fun fromSource(source: SourceEntity): String = "${source.id} ${source.name}"

    @TypeConverter
    fun toSource(source: String): SourceEntity =
        SourceEntity(source.substringBefore(' '), source.substringAfter(' '))
}