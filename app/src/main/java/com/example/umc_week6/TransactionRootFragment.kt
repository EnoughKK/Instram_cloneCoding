package com.example.umc_week6

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.umc_week6.databinding.FragmentTransactionRootBinding

class TransactionRootFragment: Fragment() {
    private lateinit var viewBinding: FragmentTransactionRootBinding

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (!childFragmentManager.popBackStackImmediate()) {
                if (!parentFragmentManager.popBackStackImmediate()) {
                    requireActivity().finish()
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(onBackPressedCallback)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTransactionRootBinding.inflate(inflater)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        childFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_root, BottomNavigationFragment(), BottomNavigationFragment::class.java.name)
            .commitAllowingStateLoss()
    }

}