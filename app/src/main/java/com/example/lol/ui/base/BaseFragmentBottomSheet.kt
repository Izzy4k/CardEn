package com.example.lol.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.example.lol.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseFragmentBottomSheet<VB : ViewBinding> : BottomSheetDialogFragment() {
    private var bindingLol: VB? = null
    protected val binding
        get() = bindingLol!!
    protected lateinit var controller: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingLol = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavigation()
        setupUi()
        setupObservers()
    }

    abstract fun getViewBinding(): VB
    abstract fun setupUi()
    abstract fun setupObservers()
    private fun initNavigation() {
        val navHostFragment =
            requireActivity().supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        controller = navHostFragment.navController
    }
}