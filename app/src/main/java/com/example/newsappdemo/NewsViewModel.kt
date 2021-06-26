package com.example.newsappdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappdemo.model.NewsData
import com.example.newsappdemo.model.NewsDataEntity
import com.example.newsappdemo.repository.NetworkMapperImpl
import com.example.newsappdemo.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Manasa on 26,June,2021
 */

@HiltViewModel
class NewsViewModel
@Inject
constructor(
    val newsRepository: NewsRepository
) : ViewModel() {


    private val liveData = MutableLiveData<List<NewsData>>()

    fun getNewsLiveData(): LiveData<List<NewsData>> {
        return liveData
    }

    fun loadNewsData(country: String, category: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<NewsDataEntity>? =
                newsRepository.fetchNewsData(country, category)

            if (response!!.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val articles = body.articles
                    val networkMapper = NetworkMapperImpl()
                    liveData.postValue(networkMapper.mapFromEntityList(articles))
                }

            }
        }

    }

}