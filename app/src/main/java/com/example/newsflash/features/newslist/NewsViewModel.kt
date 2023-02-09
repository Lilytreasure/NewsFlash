package com.example.newsflash.features.newslist

import androidx.lifecycle.*
import com.example.newsflash.api.NewsListApi
import com.example.newsflash.data.ArticlesList
import com.example.newsflash.data.NewsList
import com.example.newsflash.data.NewsRepository
import com.example.newsflash.data.Source
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    repository: NewsRepository
   // api: NewsListApi

        ):ViewModel(){

    val products=repository.getProducts().asLiveData()


    //get news

    //mutable live data and the immutable live data

//        private val articlesLiveData=MutableLiveData<Response<NewsList>>()
//
//    val news: LiveData<Response<NewsList>> = articlesLiveData
//
//     private val  apiKey:String="5a3e054de1834138a2fbc4a75ee69053"




//    init {
//      viewModelScope.launch {
//        try {
//            val articles=api.getNews("us",category = null,apiKey)
//            delay(1000)
//
//            articlesLiveData.value=articles
//            println("Data fetched Successfully")
//
//        println(articles.body())
//
//        }catch (e:Exception){
//            println("An error occurred")
//
//        }
//
//      }
//
//    }
        }