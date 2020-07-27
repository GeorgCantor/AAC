package com.georgcantor.aac.view.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.georgcantor.aac.R
import com.georgcantor.aac.databinding.FragmentBusinessBinding
import com.georgcantor.aac.view.base.DatabindingFragment
import com.georgcantor.aac.view.view.adapter.ArticleLineAdapter
import org.koin.android.viewmodel.ext.android.getViewModel

class BusinessFragment : DatabindingFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentBusinessBinding>(inflater, R.layout.fragment_business, container).apply {
            viewModel = getViewModel<MainViewModel>()
            lifecycleOwner = this@BusinessFragment
            adapter = ArticleLineAdapter()
        }.root
    }
}
