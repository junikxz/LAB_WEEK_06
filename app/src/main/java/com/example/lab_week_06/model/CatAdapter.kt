package com.example.lab_week_06.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.ImageLoader
import com.example.lab_week_06.R
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatViewHolder

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable list for storing all the list data
    private val cats = mutableListOf<CatModel>()

    // A function to set the mutable list
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        // Tell the adapter that data has changed
        notifyDataSetChanged()
    }

    // onCreateViewHolder -> inflate item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader, onClickListener)
    }

    // getItemCount -> jumlah item
    override fun getItemCount() = cats.size

    // onBindViewHolder -> ikat data ke holder
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindData(cats[position])
    }

    // OnClickListener interface
    interface OnClickListener {
        fun onItemClick(cat: CatModel)
    }
}
