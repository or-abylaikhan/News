package com.example.news.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.news.data.database.model.ArticleEntity

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    fun selectAll(): LiveData<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: ArticleEntity): Long

    @Delete
    suspend fun delete(article: ArticleEntity)
}