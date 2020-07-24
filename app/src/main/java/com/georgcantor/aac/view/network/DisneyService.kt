package com.georgcantor.aac.view.network

import com.georgcantor.aac.view.model.Poster
import retrofit2.Call
import retrofit2.http.GET

interface DisneyService {

    @GET("DisneyPosters.json")
    fun fetchDisneyPosterList(): Call<List<Poster>>
}
