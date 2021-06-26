package com.example.newsappdemo.repository

import com.example.newsappdemo.model.NewsData
import com.example.newsappdemo.model.NewsDataEntity

class NetworkMapperImpl(): NetworkMapper<NewsData, NewsDataEntity.Article> {

    override fun mapFromEntity(entity: NewsDataEntity.Article): NewsData {
        return NewsData(
            author = entity.author,
            title = entity.title,
            content = entity.content,
            description = entity.description,
            url = entity.url
        )
    }

    override fun mapToEntity(domain: NewsData): NewsDataEntity.Article {
        return NewsDataEntity.Article(
            author = domain.author,
            title = domain.title,
            content = domain.content,
            description = domain.description,
            url = domain.url
        )
    }
    fun mapFromEntityList(entities: List<NewsDataEntity.Article?>?): List<NewsData>{
        var list =ArrayList<NewsData>()
        entities!!.forEach {
            list.add(mapFromEntity(it!!))
        }
        return list.toList()
    }
}