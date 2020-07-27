package com.georgcantor.aac.view.di

import com.georgcantor.aac.view.network.ApiService
import com.georgcantor.aac.view.network.RequestInterceptor
import com.georgcantor.aac.view.repository.Repository
import com.georgcantor.aac.view.view.business.BusinessViewModel
import com.georgcantor.aac.view.view.finance.FinanceViewModel
import com.georgcantor.aac.view.view.sport.SportViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
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

val repositoryModule = module {
    single { Repository(get()) }
}

val viewModelModule = module {
    viewModel { FinanceViewModel(get()) }
    viewModel { BusinessViewModel(get()) }
    viewModel { SportViewModel(get()) }
}