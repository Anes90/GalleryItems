package com.example.galleryitems.main

import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.galleryitems.BaseFragment
import com.example.galleryitems.databinding.MainFragBinding
import com.example.galleryitems.util.list_item.ListItemAdapter

class MainFragment : BaseFragment(), MainListener {

    private lateinit var binding: MainFragBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragBinding.inflate(inflater, container, false).apply {
            viewModel = obtainViewModel(MainViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }

        binding.viewModel?.loadImagesfromSDCard(requireActivity()!!.getApplication())

        binding.viewModel?.getAllImages(requireActivity()!!.getApplication())

        binding.viewModel?.getImageList()?.observe(binding.lifecycleOwner!!,
            Observer<List<String>>{ listOfImage ->
                Log.e("Anes ", listOfImage.size.toString())}
        )

        val manager = GridLayoutManager(activity, 3)

        binding.list.layoutManager = manager

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        setupAdapter()
    }

    private fun setupAdapter() {
        binding.list.adapter = ListItemAdapter(requireContext(), this)
    }

    override fun onProfileClick(profile: ContactsContract.Profile) {

    }
}