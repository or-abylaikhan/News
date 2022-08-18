package com.example.news.data.mapper

import com.example.news.data.network.response.ArticleResponse
import com.example.news.domain.model.Article
import com.example.news.util.Mapper
import javax.inject.Inject

class ArticleResponseMapper @Inject constructor(private val sourceResponseMapper: SourceResponseMapper) :
    Mapper<Article, ArticleResponse> {
    override fun from(model: Article): ArticleResponse =
        ArticleResponse(
            sourceResponse = sourceResponseMapper.from(model.source),
            author = model.author,
            title = model.title,
            description = model.description,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            content = model.content
        )

    override fun to(model: ArticleResponse): Article =
        Article(
            source = sourceResponseMapper.to(model.sourceResponse),
            author = model.author,
            title = model.title,
            description = model.description,
            url = model.url,
            urlToImage = model.urlToImage,
            publishedAt = model.publishedAt,
            content = model.content
        )

    override fun from(model: List<Article>): List<ArticleResponse> = model.map(::from)

    override fun to(model: List<ArticleResponse>): List<Article> = model.map(::to)
}