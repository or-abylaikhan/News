package com.example.news.data.mapper

import com.example.news.data.database.model.SourceEntity
import com.example.news.domain.model.Source
import com.example.news.util.Mapper
import javax.inject.Inject


class SourceEntityMapper @Inject constructor() : Mapper<Source, SourceEntity> {

    override fun from(model: Source): SourceEntity = SourceEntity(id = model.id, name = model.name)

    override fun to(model: SourceEntity): Source = Source(id = model.id, name = model.name)

    override fun from(model: List<Source>) = model.map { from(it) }

    override fun to(model: List<SourceEntity>) = model.map { to(it) }
}