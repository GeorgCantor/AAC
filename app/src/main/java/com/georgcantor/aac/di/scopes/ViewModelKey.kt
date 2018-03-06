package com.georgcantor.aac.di.scopes

import android.arch.lifecycle.ViewModel
import com.georgcantor.aac.ui.main.MainViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Alex on 06.03.2018.
 *
 * view model key
 */
@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
internal annotation class ViewModelKey(val value: KClass<MainViewModel>)
