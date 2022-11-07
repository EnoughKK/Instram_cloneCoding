package com.example.umc_week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_week6.Transaction.TransactionRootFragment
import com.example.umc_week6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val rootTransactionFragment = TransactionRootFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_main, rootTransactionFragment, TransactionRootFragment::class.java.name)
            .commitAllowingStateLoss()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
}