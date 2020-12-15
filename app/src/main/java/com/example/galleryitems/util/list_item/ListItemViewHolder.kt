package com.example.galleryitems.util.list_item

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryitems.BR

class ListItemViewHolder(val binding: ViewDataBinding, listener: ListItemListener? = null) :
        RecyclerView.ViewHolder(binding.root) {
    init {
        binding.setVariable(BR.listener, listener)
    }

    fun onBind(item: ListItem) {
        binding.setVariable(BR.adapterPosition, adapterPosition)
        binding.setVariable(BR.item, item)
    }
}