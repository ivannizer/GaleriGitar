package com.ivan.galerigitar.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ivan.galerigitar.R

class IntroFragment2: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.intro_fragment2, container, false)
        return fragmentView
    }
    companion object{
        fun newInstance(): IntroFragment2 = IntroFragment2()
    }
}