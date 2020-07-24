package com.georgcantor.aac.view.di

import androidx.room.Room
import com.georgcantor.aac.R
import com.georgcantor.aac.view.persistence.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java,
                androidApplication().getString(R.string.database))
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

    single { get<AppDatabase>().posterDao() }
}
