package com.ivan.galerigitar.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.ivan.galerigitar.R
import com.ivan.galerigitar.presenter.IntroFragmentPresenter
import com.ivan.galerigitar.view.HomeActivity
import com.ivan.galerigitar.view.MainActivity

class IntroFragment3: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView =
            inflater.inflate(R.layout.intro_fragment3, container, false)
        val button = fragmentView.findViewById<Button>(R.id.go_to_home)
        val presenter = IntroFragmentPresenter(this.activity as MainActivity)
        presenter.setGoToHome(button)
        return fragmentView
    }
    companion object{
        fun newInstance(): IntroFragment3 = IntroFragment3()
    }
}