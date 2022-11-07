package com.example.umc_week6.ViewpagerPages

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.umc_week6.NavigationPages.ProfileFragment

class ProfileVPAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ViewpagerPage1Fragment()
            1 -> ViewpagerPage2Fragment()
            2 -> ViewpagerPage3Fragment()
            else -> ViewpagerPage1Fragment()
        }
    }
}