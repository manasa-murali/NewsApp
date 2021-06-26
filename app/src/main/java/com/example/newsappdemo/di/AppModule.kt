package com.example.newsappdemo.di

import com.example.newsappdemo.BuildConfig
import com.example.newsappdemo.repository.NewsAPI
import com.example.newsappdemo.repository.NewsRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Manasa on 26,June,2021
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson): Retrofit {
       return Retrofit.Builder()
           .baseUrl(BuildConfig.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create(gson))
           .build()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
       return Gson()
    }

    @Provides
    @Singleton
    fun providesNewsService(retrofit: Retrofit): NewsAPI{
       return retrofit.create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(newsAPI: NewsAPI): NewsRepository{
        return NewsRepository(newsAPI)
    }

//    @Provides
//    fun provideCoroutineDispatcher(): CoroutineDispatcher{
//       return Dispatchers.IO
//    }
}