package com.myprojects.mynewsapp.data.network

import com.myprojects.mynewsapp.Constants.API_KEY
import com.myprojects.mynewsapp.data.model.NewsDTO
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=6eadc133518f4a0ea84f61db3fa64dfc

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsDTO>
}