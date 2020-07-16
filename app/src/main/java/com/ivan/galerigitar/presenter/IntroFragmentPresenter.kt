package com.ivan.galerigitar.presenter

import android.content.Intent
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import com.ivan.galerigitar.view.HomeActivity
import com.ivan.galerigitar.view.MainActivity

class IntroFragmentPresenter(private val activity: MainActivity) {
    fun setGoToHome(button: Button){
        button.setOnClickListener {
            val intent = Intent(activity, HomeActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.baseContext.startActivity(intent)
        }
    }
}