package com.ivan.galerigitar.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ivan.galerigitar.R
import com.ivan.galerigitar.presenter.GitarPresenter
import com.ivan.galerigitar.view.adapters.GitarRVAdapter

class GitarActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var presenter: GitarPresenter
    private lateinit var galeriRVAdapter: GitarRVAdapter

    private lateinit var arr: ArrayList<Int>
    private lateinit var ket: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gitar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Daftar Gitar"
        val kategori: Int = intent.extras?.getInt("kategori")!!
        presenter = GitarPresenter(this, kategori)
        ket = presenter.fetchNama()
        arr = presenter.fetchGambar()
        recyclerView = findViewById(R.id.rv_gitar)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        galeriRVAdapter = GitarRVAdapter(arr, ket, this, kategori)
        recyclerView.adapter = galeriRVAdapter
        recyclerView.setHasFixedSize(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return presenter.onOptionsItemSelected(item)
    }
}