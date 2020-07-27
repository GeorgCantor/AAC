package com.georgcantor.aac.view.view.main

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.georgcantor.aac.R
import com.georgcantor.aac.databinding.ActivityMainBinding
import com.georgcantor.aac.view.base.DatabindingActivity
import com.georgcantor.aac.view.utils.applyExitMaterialTransform
import com.georgcantor.aac.view.view.business.BusinessFragment
import com.georgcantor.aac.view.view.finance.FinanceFragment
import com.georgcantor.aac.view.view.sport.SportFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DatabindingActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    private lateinit var mainPagerAdapter: MainPagerAdapter
    private lateinit var pager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        applyExitMaterialTransform()
        super.onCreate(savedInstanceState)
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager).apply {
            addFragment(FinanceFragment())
            addFragment(BusinessFragment())
            addFragment(SportFragment())
        }

        binding.apply {
            pagerAdapter = mainPagerAdapter
            navigation = mainBottomNavigation
            pager = main_viewpager
        }
    }

    override fun onBackPressed() {
        when (pager.currentItem) {
            0 -> super.onBackPressed()
            1 -> pager.currentItem = 0
            2 -> pager.currentItem = 1
        }
    }
}
