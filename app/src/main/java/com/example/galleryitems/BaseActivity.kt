package com.example.galleryitems

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


abstract class BaseActivity : AppCompatActivity() {

    protected fun <T : ViewModel> obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProvider(
            this,
            ViewModelFactory(application, this)
        ).get(viewModelClass)

    
    //Test of the Jira + GitHub integration
}