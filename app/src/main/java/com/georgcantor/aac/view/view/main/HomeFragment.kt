package com.georgcantor.aac.view.view.main

import android.graphics.Color
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.georgcantor.aac.R
import com.georgcantor.aac.databinding.FragmentHomeBinding
import com.georgcantor.aac.view.base.DatabindingFragment
import com.georgcantor.aac.view.extensions.gone
import com.georgcantor.aac.view.extensions.visible
import com.georgcantor.aac.view.view.adapter.PosterAdapter
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import org.koin.android.viewmodel.ext.android.getViewModel

class HomeFragment : DatabindingFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = binding<FragmentHomeBinding>(inflater, R.layout.fragment_home, container).apply {
            viewModel = getViewModel<MainViewModel>()
            lifecycleOwner = this@HomeFragment
            adapter = PosterAdapter()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.container, getTransform(it, binding.card))
            binding.card.visible()
            it.gone(true)
        }

        binding.card.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.container, getTransform(it, binding.fab))
            binding.fab.visible()
            it.gone(true)
        }
    }

    private fun getTransform(mStartView: View, mEndView: View): MaterialContainerTransform {
        return MaterialContainerTransform().apply {
            startView = mStartView
            endView = mEndView
            addTarget(mEndView)
            pathMotion = MaterialArcMotion()
            duration = 550
            scrimColor = Color.TRANSPARENT
        }
    }
}
