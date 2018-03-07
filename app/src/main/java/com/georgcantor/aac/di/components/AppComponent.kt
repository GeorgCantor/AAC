package com.georgcantor.aac.di.components

import android.app.Application
import com.georgcantor.aac.MainApp
import com.georgcantor.aac.di.modules.ActivityModule
import com.georgcantor.aac.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Alex on 07.03.2018.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: MainApp)
}