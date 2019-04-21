package com.georgcantor.aac.model.remote

import com.georgcantor.aac.model.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("top-headlines")
    fun getHeadlines(@Query("sources") sources: String,
                     @Query("apiKey") apiKey: String): Call<NewsResponse>

    @GET("everything")
    fun getSearchResults(@Query("q") query: String,
                         @Query("sortBy") sortBy: String,
                         @Query("language") language: String,
                         @Query("apiKey") apiKey: String): Call<NewsResponse>

    @GET("top-headlines")
    fun getHeadlinesCountry(@Query("country") country: String,
                            @Query("apiKey") apiKey: String): Call<NewsResponse>
}