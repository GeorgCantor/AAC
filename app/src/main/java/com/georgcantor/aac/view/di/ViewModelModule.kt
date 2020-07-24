package com.georgcantor.aac.view.di

import com.georgcantor.aac.view.view.details.PosterDetailViewModel
import com.georgcantor.aac.view.view.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
    viewModel { PosterDetailViewModel(get()) }
}
