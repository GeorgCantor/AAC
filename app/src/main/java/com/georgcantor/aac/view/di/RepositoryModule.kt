package com.georgcantor.aac.view.di

import com.georgcantor.aac.view.repository.DetailRepository
import com.georgcantor.aac.view.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { MainRepository(get(), get()) }
    single { DetailRepository(get()) }
}
