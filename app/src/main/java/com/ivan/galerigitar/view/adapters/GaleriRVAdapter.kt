package com.ivan.galerigitar.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivan.galerigitar.R
import com.ivan.galerigitar.presenter.HomePresenter
import com.ivan.galerigitar.view.HomeActivity

class GaleriRVAdapter(): RecyclerView.Adapter<GaleriRVAdapter.GaleriViewHolder>(){
    private lateinit var arr: ArrayList<Int>
    private lateinit var ket: ArrayList<String>
    private lateinit var activity: HomeActivity

    constructor(arr: ArrayList<Int>, ket: ArrayList<String>, activity: HomeActivity) : this() {
        this.arr = arr
        this.ket = ket
        this.activity = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        val galeriViewHolder = GaleriViewHolder(view)
        return galeriViewHolder
    }
    override fun getItemCount(): Int {
        return this.arr.size
    }
    override fun onBindViewHolder(holder: GaleriViewHolder, position: Int) {
        holder.imageView.setImageResource(arr.get(position))
        holder.textView.text = ket.get(position)
        val presenter = HomePresenter(activity)
        presenter.onRVitemClicked(holder.itemView, position)
    }
    class GaleriViewHolder: RecyclerView.ViewHolder {
        var imageView: ImageView
        var textView: TextView
        constructor(itemView: View) : super(itemView) {
            imageView = itemView.findViewById<ImageView>(R.id.galeri_item)
            textView = itemView.findViewById<TextView>(R.id.galeri_item_ket)

        }

    }
}