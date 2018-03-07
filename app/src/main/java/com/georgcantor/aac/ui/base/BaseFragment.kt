package com.georgcantor.aac.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.ViewDataBinding
import android.support.v4.app.Fragment
import javax.inject.Inject

/**
 * Created by Alex on 07.03.2018.
 *
 * This is a base fragment class that will extend all the fragments in the app
 */
abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : Fragment() {

    // view model factory instance
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
}