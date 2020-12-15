package com.example.galleryitems.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryitems.util.list_item.ListItem
import com.example.galleryitems.util.list_item.ListItemBindings.bindListItems

object MainBindings {

    @JvmStatic
    @BindingAdapter("app:images_list")
    fun RecyclerView.bindMainImages(allImages: List<String>?) {

        if (!allImages.isNullOrEmpty()) {
            val images = mutableListOf<ListItem>()

            allImages.forEach { p ->
                images.add(MainItem(p))
            }

            bindListItems(images)
        } else {
            bindListItems(listOf())
        }
    }

    @JvmStatic
    @BindingAdapter("loadImage")
    fun bindingImage(userImageView: ImageView, imageUri: String){
        Glide.with(userImageView.context).load(imageUri).into(userImageView)
    }
}