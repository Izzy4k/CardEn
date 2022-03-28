package com.example.lol.ui.fragment.remember

import com.example.lol.databinding.FragmentRememberBinding
import com.example.lol.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RememberFragment : BaseFragment<FragmentRememberBinding>() {
    override fun getViewBinding(): FragmentRememberBinding =
        FragmentRememberBinding.inflate(layoutInflater)

    override fun setupUi() {
    }

    override fun setupObservers() {
    }


}