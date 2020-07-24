package com.georgcantor.aac.view.view.main

import android.os.Bundle
import com.georgcantor.aac.R
import com.georgcantor.aac.databinding.ActivityMainBinding
import com.georgcantor.aac.view.base.DatabindingActivity
import com.georgcantor.aac.view.extensions.applyExitMaterialTransform
import org.koin.android.viewmodel.ext.android.getViewModel

class MainActivity : DatabindingActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        applyExitMaterialTransform()
        super.onCreate(savedInstanceState)
        binding.apply {
            pagerAdapter = MainPagerAdapter(supportFragmentManager)
            navigation = mainBottomNavigation
            vm = getViewModel()
        }
    }
}
