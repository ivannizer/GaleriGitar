package com.ivan.galerigitar.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ivan.galerigitar.R
import com.ivan.galerigitar.view.adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intro_viewpager.adapter = MyPagerAdapter(supportFragmentManager)
        tabLayoutPager.setupWithViewPager(intro_viewpager)
    }
}