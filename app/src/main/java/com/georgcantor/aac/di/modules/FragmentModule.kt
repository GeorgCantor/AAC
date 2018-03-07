package com.georgcantor.aac.di.modules

import com.georgcantor.aac.ui.main.MainActivityFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Alex on 07.03.2018.
 *
 * this class will inject all the fragments in our app
 */
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainActivityFragment
}