package com.ivan.galerigitar.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.ivan.galerigitar.R
import com.ivan.galerigitar.presenter.DetailPresenter

class DetailActivity : AppCompatActivity() {
    private lateinit var presenter: DetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        title = "Informasi Gitar"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val kategori = intent.extras?.getInt("kategori")!!
        val gitar = intent.extras?.getInt("gitar")!!

        presenter = DetailPresenter(this, kategori, gitar)
        presenter.setAll()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return presenter.onOptionsItemSelected(item)
    }
}