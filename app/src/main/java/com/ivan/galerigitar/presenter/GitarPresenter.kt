package com.ivan.galerigitar.presenter

import android.content.Intent
import android.view.MenuItem
import android.view.View
import com.ivan.galerigitar.model.GitarModel
import com.ivan.galerigitar.view.DetailActivity
import com.ivan.galerigitar.view.GitarActivity

class GitarPresenter(private val activity: GitarActivity, private val kategori: Int) {
    val gitarModel: GitarModel = GitarModel(activity)

    fun onOptionsItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            android.R.id.home -> {
                activity.onBackPressed()
                activity.finish()
                return true
            }
            else -> {
                return false
            }
        }
    }

    fun onRVitemClicked(view: View, pos: Int){
        view.setOnClickListener{
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra("kategori", kategori)
            intent.putExtra("gitar", pos)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.baseContext.startActivity(intent)
        }
    }
    fun fetchNama(): ArrayList<String>{
        return gitarModel.getName(kategori)
    }
    fun fetchGambar(): ArrayList<Int>{
        return gitarModel.getGambar(kategori)
    }
}