package com.georgcantor.aac.view.view.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.georgcantor.aac.view.view.business.BusinessFragment
import com.georgcantor.aac.view.view.finance.FinanceFragment
import com.georgcantor.aac.view.view.sport.SportFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FinanceFragment()
            1 -> BusinessFragment()
            else -> SportFragment()
        }
    }

    override fun getCount() = 3
}
