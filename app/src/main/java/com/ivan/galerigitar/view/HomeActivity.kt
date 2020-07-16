package com.ivan.galerigitar.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivan.galerigitar.R
import com.ivan.galerigitar.presenter.HomePresenter
import com.ivan.galerigitar.view.adapters.GaleriRVAdapter

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var presenter: HomePresenter
    private lateinit var galeriRVAdapter: GaleriRVAdapter

    private lateinit var arr: ArrayList<Int>
    private lateinit var ket: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter = HomePresenter(this)
        arr = presenter.fetchGambar()
        ket = presenter.fetchNama()
        recyclerView = findViewById(R.id.rv_galeri)
        layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        galeriRVAdapter = GaleriRVAdapter(arr, ket, this)
        recyclerView.adapter = galeriRVAdapter
        recyclerView.setHasFixedSize(true)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onBackPressed() {
        presenter.onBackPressed()
    }
}