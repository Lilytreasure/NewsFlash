package com.example.newsflash.api

import android.transition.ArcMotion
import com.example.newsflash.data.ArticlesList
import com.example.newsflash.data.NewsList
import com.example.newsflash.data.Source
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsListApi {

    companion object{
        const val BASE_URL="https://newsapi.org/v2/"
    }

    //Get request

    @GET("top-headlines")

    //parameters as directed in the api
    //using Call in the querry
    //call list


   suspend fun getNews(@Query("country") country : String,
               @Query("category") category : String?,
                @Query("apiKey") key : String) : Response<NewsList>

}