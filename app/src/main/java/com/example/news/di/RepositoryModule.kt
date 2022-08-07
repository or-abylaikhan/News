package com.example.news.di

import com.example.news.data.repository.ArticleRepositoryImpl
import com.example.news.domain.repository.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindArticleRepository(articleRepositoryImpl: ArticleRepositoryImpl): ArticleRepository
}