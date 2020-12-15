package com.example.galleryitems.util.list_item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ListItemAdapter(context: Context, private val listener: ListItemListener? = null) : RecyclerView.Adapter<ListItemViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    private var items = listOf<ListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, layout: Int): ListItemViewHolder {
        return ListItemViewHolder(
                DataBindingUtil.inflate(
                        inflater,
                        layout,
                        parent,
                        false
                ),
                listener
        )
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].layout
    }

    fun setItems(newItems: List<ListItem>) {
        val oldItems = items
        val result = DiffUtil.calculateDiff(
                ListItemDiffCallback(oldItems, newItems)
        )
        items = newItems
        result.dispatchUpdatesTo(this)
    }

    fun getItems(): List<ListItem> {
        return items
    }

}