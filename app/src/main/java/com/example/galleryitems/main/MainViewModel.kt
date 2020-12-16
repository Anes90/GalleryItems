package com.example.galleryitems.main

import android.app.Application
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

@Suppress("DEPRECATION")
class MainViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main

    val imagesLiveData: MutableLiveData<List<String>> = MutableLiveData()
    fun getImageList(): MutableLiveData<List<String>> {
        return imagesLiveData
    }

    /**
     * Getting All Images Path.
     *
     * Required Storage Permission
     *
     * @return ArrayList with images Path
     */
    internal fun loadImagesfromSDCard(application: Application): ArrayList<String> {
        val uri: Uri = android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI
        val cursor: Cursor?
        val column_index_data: Int
        val column_index_folder_name: Int
        val listOfAllImages = ArrayList<String>()
        var absolutePathOfImage: String? = null

        val projection = arrayOf(
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME)

        cursor = application.contentResolver!!.query(uri, projection, null, null, null)

        column_index_data = cursor!!.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
        column_index_folder_name = cursor!!
            .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
        while (cursor!!.moveToNext()) {
            absolutePathOfImage = cursor!!.getString(column_index_data)
            listOfAllImages.add(absolutePathOfImage)
        }
        return listOfAllImages
    }

    fun getAllImages(application: Application) {
        launch(Dispatchers.Main) {
            imagesLiveData.value = withContext(Dispatchers.IO) {
                loadImagesfromSDCard(application)
            }
        }
    }
}