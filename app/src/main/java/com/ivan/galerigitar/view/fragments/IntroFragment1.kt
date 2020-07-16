package com.ivan.galerigitar.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ivan.galerigitar.R

class IntroFragment1(): Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.intro_fragment1, container, false)
        return fragmentView
    }
    companion object{
        fun newInstance(): IntroFragment1 = IntroFragment1()
    }
}