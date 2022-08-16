package com.example.news.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.news.data.database.entity.ArticleEntity

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles ORDER BY publishedAt DESC")
    fun selectAll(): LiveData<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: ArticleEntity)

    @Delete
    suspend fun delete(article: ArticleEntity)

    @Query("SELECT EXISTS (SELECT * FROM articles WHERE url = :url)")
    fun alreadyExists(url: String): LiveData<Boolean>
}