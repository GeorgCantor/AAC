package com.georgcantor.aac.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.georgcantor.aac.R
import com.georgcantor.aac.view.fragment.NewsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var newsFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsFragment = NewsFragment()
        if (savedInstanceState == null) {
            loadFragment(newsFragment)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}
