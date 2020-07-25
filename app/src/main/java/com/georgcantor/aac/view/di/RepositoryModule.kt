package com.georgcantor.aac.view.di

import com.georgcantor.aac.view.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {

    single { Repository(get()) }
}
