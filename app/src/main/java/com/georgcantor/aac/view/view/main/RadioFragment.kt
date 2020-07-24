package com.georgcantor.aac.view.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.georgcantor.aac.R
import com.georgcantor.aac.databinding.FragmentRadioBinding
import com.georgcantor.aac.view.base.DatabindingFragment
import com.georgcantor.aac.view.view.adapter.PosterCircleAdapter
import org.koin.android.viewmodel.ext.android.getViewModel

class RadioFragment : DatabindingFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentRadioBinding>(inflater, R.layout.fragment_radio, container).apply {
            viewModel = getViewModel<MainViewModel>().apply { fetchDisneyPosterList() }
            lifecycleOwner = this@RadioFragment
            adapter = PosterCircleAdapter()
        }.root
    }
}
