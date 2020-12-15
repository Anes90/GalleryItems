package com.example.galleryitems.util.list_item

abstract class ListItem(val layout: Int) : Cloneable {

    abstract fun areItemsTheSame(listItem: ListItem): Boolean

    abstract fun areContentsTheSame(listItem: ListItem): Boolean

    //public override fun clone(): Any {
    //    return super.clone()
    //}

}