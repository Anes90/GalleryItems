package com.example.galleryitems.main

import com.example.galleryitems.R
import com.example.galleryitems.util.list_item.ListItem

class MainItem(val image: String) : ListItem(R.layout.main_item) {
    override fun areItemsTheSame(listItem: ListItem): Boolean {
        return listItem is MainItem && listItem.image == image
    }

    override fun areContentsTheSame(listItem: ListItem): Boolean {
        return listItem is MainItem && listItem.image == image
    }
}