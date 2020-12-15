package com.example.galleryitems.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.galleryitems.BaseActivity
import com.example.galleryitems.R
import com.example.galleryitems.databinding.MainActBinding


class MainActivity : BaseActivity() {

    private lateinit var binding: MainActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_act)
        binding.apply {
            viewModel = obtainViewModel(MainViewModel::class.java)
            lifecycleOwner = this@MainActivity
        }
    }

}