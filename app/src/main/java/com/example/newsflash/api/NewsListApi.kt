package com.example.newsflash.api

import com.example.newsflash.data.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsListApi {

    companion object{
        const val BASE_URL="https://newsapi.org/v2/"
    }

    //Get request

    @GET("/v2/top-headlines/")

    //parameters as directed in the api

    fun getNews(@Query("country") country : String,
                @Query("category") category : String?,
                @Query("apiKey") key : String) : Call<NewsList>



}