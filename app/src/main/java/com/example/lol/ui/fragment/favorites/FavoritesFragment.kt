package com.example.lol.ui.fragment.favorites

import com.example.lol.databinding.FragmentFavoritesBinding
import com.example.lol.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {
    override fun getViewBinding(): FragmentFavoritesBinding =
        FragmentFavoritesBinding.inflate(layoutInflater)

    override fun setupUi() {
    }

    override fun setupObservers() {
    }

}