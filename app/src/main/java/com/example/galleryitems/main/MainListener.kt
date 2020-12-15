package com.example.galleryitems.main

import android.provider.ContactsContract
import com.example.galleryitems.util.list_item.ListItemListener

interface MainListener : ListItemListener {

    fun onProfileClick(profile: ContactsContract.Profile)

}