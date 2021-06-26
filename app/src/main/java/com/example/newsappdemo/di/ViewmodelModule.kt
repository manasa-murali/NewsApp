package com.example.newsappdemo.di

import com.example.newsappdemo.NewsViewModel
import com.example.newsappdemo.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Manasa on 26,June,2021
 */

@Module
@InstallIn(ViewModelComponent::class)
class ViewmodelModule {

    @Provides
    @ViewModelScoped
    fun provideVM(newsRepository: NewsRepository): NewsViewModel{
        return NewsViewModel(newsRepository)
    }
}