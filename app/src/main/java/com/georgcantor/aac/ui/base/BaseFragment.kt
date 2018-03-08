package com.georgcantor.aac.ui.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
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

    // data binding instance
    lateinit var dataBinding: DB

    // view model instance
    lateinit var viewModel: VM

    abstract fun getViewModel(): Class<VM>

    @LayoutRes
    abstract fun getLayoutRes(): Int

    //override onCreate method of fragment that will inject this fragment and set its view model
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    }

    //override onCreateView method that will set the data binding view
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        return dataBinding.root
    }
}