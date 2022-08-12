package com.example.news.data.mapper

import com.example.news.data.network.model.SourceResponse
import com.example.news.domain.model.Source
import com.example.news.util.Mapper
import javax.inject.Inject

class SourceResponseMapper @Inject constructor() : Mapper<Source, SourceResponse> {

    override fun from(model: Source) = SourceResponse(id = model.id, name = model.name)

    override fun to(model: SourceResponse): Source = Source(id = model.id, name = model.name)

    override fun from(model: List<Source>): List<SourceResponse> = model.map { from(it) }

    override fun to(model: List<SourceResponse>): List<Source> = model.map { to(it) }
}