package com.ivan.galerigitar.presenter

import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.ivan.galerigitar.R
import com.ivan.galerigitar.model.GitarModel
import com.ivan.galerigitar.view.DetailActivity

class DetailPresenter(private val activity: DetailActivity, private val kategori: Int, private val gitar: Int) {
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

    fun setAll(){
        val arr = fetchData()
        val tvNama = activity.findViewById<TextView>(R.id.detail_nama)
        val ivGbr = activity.findViewById<ImageView>(R.id.detail_gbr)
        val tvKet = activity.findViewById<TextView>(R.id.detail_ket)
        tvNama.text = arr.get(0)
        ivGbr.setImageResource(arr.get(1).toInt())
        tvKet.text = activity.getString(arr.get(2).toInt())
    }

    fun fetchData(): ArrayList<String>{
        return gitarModel.getNameSrcDetail(kategori, gitar)
    }

}