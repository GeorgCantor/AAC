package com.georgcantor.aac.view

import android.app.Application
import com.georgcantor.aac.view.di.networkModule
import com.georgcantor.aac.view.di.persistenceModule
import com.georgcantor.aac.view.di.repositoryModule
import com.georgcantor.aac.view.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, persistenceModule, repositoryModule, viewModelModule))
        }
    }
}