package com.georgcantor.aac.di.modules

import com.georgcantor.aac.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Alex on 07.03.2018.
 *
 * this class will include all activities in our app
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentModule::class))
    abstract fun mainActivity(): MainActivity
}