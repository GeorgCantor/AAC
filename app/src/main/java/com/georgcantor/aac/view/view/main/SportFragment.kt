package com.georgcantor.aac.view.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.georgcantor.aac.R
import com.georgcantor.aac.databinding.FragmentSportBinding
import com.georgcantor.aac.view.base.DatabindingFragment
import com.georgcantor.aac.view.view.adapter.ArticleCircleAdapter
import org.koin.android.viewmodel.ext.android.getViewModel

class SportFragment : DatabindingFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentSportBinding>(inflater, R.layout.fragment_sport, container).apply {
            viewModel = getViewModel<MainViewModel>()
            lifecycleOwner = this@SportFragment
            adapter = ArticleCircleAdapter()
        }.root
    }
}
