package com.example.umc_week6.Transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_week6.NavigationPages.HomeFragment
import com.example.umc_week6.NavigationPages.ProfileFragment
import com.example.umc_week6.R
import com.example.umc_week6.NavigationPages.SearchFragment
import com.example.umc_week6.databinding.FragmentBottomNavigationBinding

class BottomNavigationFragment: Fragment() {
    private lateinit var viewBinding: FragmentBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentBottomNavigationBinding.inflate(inflater)

        childFragmentManager // 앱 실행시 홈 프래그먼트 add
            .beginTransaction()
            .add(R.id.fragment_container_navigationview, HomeFragment(), HomeFragment::class.java.name)
            .commitAllowingStateLoss()

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.bottomNavigation.setOnItemSelectedListener { item ->
            val transaction = childFragmentManager.beginTransaction() // 프래그먼트가 호출 될 때

            val currentFragment = childFragmentManager.primaryNavigationFragment

            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }

            val fragmentTag = item.title.toString()
            var newFragment: Fragment? = childFragmentManager.findFragmentByTag(fragmentTag)

            if (newFragment == null) {
                when (item.itemId) {
                    R.id.Home -> {
                        newFragment = HomeFragment()
                        true
                    }
                    R.id.Search -> {
                        newFragment = SearchFragment()
                        true
                    }

                    R.id.Profile -> {
                        newFragment = ProfileFragment()
                        true
                    }
                    else -> false
                }

                transaction
                    .add(R.id.fragment_container_navigationview, newFragment!!, tag)
                    .addToBackStack(tag)

            } else {
                transaction.show(newFragment)
            }

            transaction
                .setPrimaryNavigationFragment(newFragment)
                .commitAllowingStateLoss()
            true
        }
    }
}