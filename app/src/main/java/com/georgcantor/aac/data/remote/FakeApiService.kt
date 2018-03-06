package com.georgcantor.aac.data.remote

import com.georgcantor.aac.data.local.entity.FakePost
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Alex on 06.03.2018.
 */
interface FakeApiService {

    @GET("/posts")
    fun getFakePosts(): Single<List<FakePost>>
}