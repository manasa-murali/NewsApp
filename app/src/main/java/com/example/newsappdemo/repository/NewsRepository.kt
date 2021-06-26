package com.example.newsappdemo.repository

import com.example.newsappdemo.model.NewsDataEntity
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Manasa on 26,June,2021
 */
class NewsRepository
@Inject
constructor(private val newsAPI: NewsAPI)
{
    suspend fun fetchNewsData(country: String, category: String): Response<NewsDataEntity>? {
        val response = newsAPI.fetchDatafromNetwork(country, category)
        return response
    }
}