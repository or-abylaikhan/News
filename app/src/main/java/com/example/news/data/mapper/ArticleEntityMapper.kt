package com.example.news.data.mapper

import com.example.news.data.database.entity.ArticleEntity
import com.example.news.domain.model.Article
import com.example.news.util.Mapper
import javax.inject.Inject

class ArticleEntityMapper @Inject constructor(private val sourceEntityMapper: SourceEntityMapper) :
    Mapper<Article, ArticleEntity> {

    override fun from(model: Article): ArticleEntity =
        ArticleEntity(
            source = sourceEntityMapper.from(model.source),
            author = model.author,
            title = model.title,
            description = model.description,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            content = model.content
        )


    override fun to(model: ArticleEntity): Article =
        Article(
            source = sourceEntityMapper.to(model.source),
            author = model.author,
            title = model.title,
            description = model.description,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            content = model.content,
        )

    override fun from(model: List<Article>): List<ArticleEntity> = model.map { from(it) }

    override fun to(model: List<ArticleEntity>): List<Article> = model.map { to(it) }
}