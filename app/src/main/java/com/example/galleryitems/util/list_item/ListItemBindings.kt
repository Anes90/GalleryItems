package com.example.galleryitems.util.list_item

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

object ListItemBindings {

    @JvmStatic
    @BindingAdapter("app:listItems")
    fun RecyclerView.bindListItems(items: List<ListItem>?) {
        (adapter as ListItemAdapter).setItems(items ?: listOf())
    }

    @JvmStatic
    @BindingAdapter("app:listItems")
    fun ViewPager2.bindListItems(items: List<ListItem>?) {
        (adapter as ListItemAdapter).setItems(items ?: listOf())
    }


}