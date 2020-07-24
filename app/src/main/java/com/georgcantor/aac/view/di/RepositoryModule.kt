package com.georgcantor.aac.view.di

import org.koin.dsl.module

val repositoryModule = module {

    single { MainRepository(get(), get()) }
    single { DetailRepository(get()) }
}
