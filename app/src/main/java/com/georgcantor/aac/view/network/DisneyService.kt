package com.georgcantor.aac.view.network

import com.georgcantor.aac.view.model.Poster
import retrofit2.Response
import retrofit2.http.GET

interface DisneyService {

    @GET("DisneyPosters.json")
    suspend fun getPosters(): Response<List<Poster>>
}
