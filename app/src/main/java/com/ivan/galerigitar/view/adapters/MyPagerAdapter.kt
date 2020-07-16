package com.ivan.galerigitar.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ivan.galerigitar.view.fragments.IntroFragment1
import com.ivan.galerigitar.view.fragments.IntroFragment2
import com.ivan.galerigitar.view.fragments.IntroFragment3

@Suppress("DEPRECATION")
class MyPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

    private val pages = listOf(
        IntroFragment1.newInstance(),
        IntroFragment2.newInstance(),
        IntroFragment3.newInstance()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    /*override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> "Third Tab"
        }
    }*/
}