package com.example.umc_week6.NavigationPages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_week6.R
import com.example.umc_week6.ViewpagerPages.ProfileVPAdapter
import com.example.umc_week6.databinding.FragmentProfileBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment: Fragment() {
    private lateinit var viewBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProfileBinding.inflate(inflater)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileVPAdapter = ProfileVPAdapter(this)
        viewBinding.vpMain.adapter = profileVPAdapter

        val tabIconArray = arrayOf(
            R.drawable.ic_baseline_grid_on_24,
            R.drawable.ic_baseline_photo_filter_24,
            R.drawable.ic_baseline_photo_camera_back_24
        )

        TabLayoutMediator(viewBinding.TapMain, viewBinding.vpMain) { tab, position ->
            tab.setIcon(tabIconArray[position])
        }.attach()
    }
}