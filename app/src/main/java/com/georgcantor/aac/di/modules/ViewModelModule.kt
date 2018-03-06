package com.georgcantor.aac.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.georgcantor.aac.VMFactory
import com.georgcantor.aac.di.scopes.ViewModelKey
import com.georgcantor.aac.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Alex on 06.03.2018.
 *
 * this will inject/binds all the view models in our app
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(MainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(vmFactory: VMFactory): ViewModelProvider.Factory

}