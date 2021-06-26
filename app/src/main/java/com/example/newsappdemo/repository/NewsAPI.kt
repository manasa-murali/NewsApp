package com.example.newsappdemo.repository

import com.example.newsappdemo.model.NewsDataEntity
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Manasa on 26,June,2021
 */
interface NewsAPI {

    @GET("v2/top-headlines?apiKey=33e3d5c9025f4396abaf8ef471ea35a8")
    suspend fun fetchDatafromNetwork(
        @Query("country") country: String,
        @Query("category") category: String
    ): Response<NewsDataEntity>
}