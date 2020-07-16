package com.ivan.galerigitar.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivan.galerigitar.R
import com.ivan.galerigitar.presenter.GitarPresenter
import com.ivan.galerigitar.view.GitarActivity

class GitarRVAdapter(): RecyclerView.Adapter<GitarRVAdapter.GitarViewHolder>(){
    private lateinit var arr: ArrayList<Int>
    private lateinit var ket: ArrayList<String>
    private lateinit var activity: GitarActivity
    private var kategori: Int = 0

    constructor(arr: ArrayList<Int>, ket: ArrayList<String>, activity: GitarActivity, kategori: Int) : this() {
        this.arr = arr
        this.ket = ket
        this.activity = activity
        this.kategori = kategori
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gitar, parent, false)
        val galeriViewHolder = GitarViewHolder(view)
        return galeriViewHolder
    }

    override fun getItemCount(): Int {
        return this.arr.size
    }

    override fun onBindViewHolder(holder: GitarViewHolder, position: Int) {
        holder.imageView.setImageResource(arr.get(position))
        holder.textView.text = ket.get(position)
        val presenter = GitarPresenter(activity, kategori)
        presenter.onRVitemClicked(holder.itemView, position)
    }
    class GitarViewHolder: RecyclerView.ViewHolder {
        var imageView: ImageView
        var textView: TextView
        constructor(itemView: View) : super(itemView) {
            imageView = itemView.findViewById<ImageView>(R.id.gitar_gbr)
            textView = itemView.findViewById<TextView>(R.id.gitar_ket)
        }
    }
}