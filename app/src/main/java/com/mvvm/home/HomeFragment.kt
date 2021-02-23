package com.mvvm.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mvvm.R
import com.mvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentHomeBinding.bind(view)
    }
}