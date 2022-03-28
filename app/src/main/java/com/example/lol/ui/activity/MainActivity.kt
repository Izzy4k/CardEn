package com.example.lol.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.lol.R
import com.example.lol.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navController = findNavController(R.id.nav_host_fragment_activity_main)


        binding.navView.setupWithNavController(navController)

        binding.navView.itemIconTintList = null
        initListener()
    }

    private fun initListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.navView.isVisible = destination.id != R.id.wordFragment

        }
    }
}