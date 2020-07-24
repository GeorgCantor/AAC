package com.georgcantor.aac.view.di

import com.georgcantor.aac.view.network.ApiService
import com.georgcantor.aac.view.network.RequestInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor())
                .build()
    }

    single {
        Retrofit.Builder()
                .client(get<OkHttpClient>())
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }
}
