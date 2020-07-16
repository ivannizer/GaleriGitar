package com.ivan.galerigitar.presenter

import android.content.Intent
import android.os.Build
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import com.ivan.galerigitar.model.GaleriModel
import com.ivan.galerigitar.view.GitarActivity
import com.ivan.galerigitar.view.HomeActivity

class HomePresenter(private val activity: HomeActivity){
    private var doubleBackToExitPressedOnce = false
    val galeriModel: GaleriModel = GaleriModel(activity)

    fun fetchNama(): ArrayList<String>{
        return galeriModel.getName()
    }

    fun fetchGambar(): ArrayList<Int>{
        return galeriModel.getImageSrc()
    }

    fun onRVitemClicked(view: View, pos: Int){
        view.setOnClickListener{
            val intent = Intent(activity, GitarActivity::class.java)
            intent.putExtra("kategori", pos)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.baseContext.startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun onBackPressed(){
        if(doubleBackToExitPressedOnce){
            activity.finishAffinity()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(activity, "Harap Tekan Tombol 'Back' Lagi Untuk Keluar!", Toast.LENGTH_SHORT).show()

        @Suppress("DEPRECATION")
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}