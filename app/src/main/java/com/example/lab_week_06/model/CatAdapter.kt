package com.example.lab_week_06.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.ImageLoader
import com.example.lab_week_06.R

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable list untuk menyimpan semua data kucing
    private val cats = mutableListOf<CatModel>()

    // Fungsi untuk set data baru ke dalam adapter
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        // Beri tahu adapter kalau data berubah
        notifyDataSetChanged()
    }

    // Membuat ViewHolder (inflate layout item_list.xml)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader)
    }

    // Mengembalikan jumlah item dalam list
    override fun getItemCount(): Int = cats.size

    // Binding data ke ViewHolder
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindData(cats[position])
    }
}
