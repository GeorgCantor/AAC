package com.georgcantor.aac.view.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
    viewModel { PosterDetailViewModel(get()) }
}
