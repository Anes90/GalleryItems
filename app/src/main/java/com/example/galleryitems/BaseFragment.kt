package com.example.galleryitems

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


abstract class BaseFragment : Fragment() {

    protected fun <T : ViewModel> obtainViewModel(viewModelClass: Class<T>) =
        ViewModelProvider(
            requireActivity(),
            ViewModelFactory(requireActivity().application, requireActivity())
        ).get(viewModelClass)

}