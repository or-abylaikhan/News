package com.example.news.di

import android.content.Context
import androidx.room.Room
import com.example.news.data.database.ArticleDao
import com.example.news.data.database.ArticleDatabase
import com.example.news.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideArticleDao(articleDatabase: ArticleDatabase): ArticleDao = articleDatabase.articleDao

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ArticleDatabase =
        Room.databaseBuilder(appContext, ArticleDatabase::class.java, DATABASE_NAME).build()
}