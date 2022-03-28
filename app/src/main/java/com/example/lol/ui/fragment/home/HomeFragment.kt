package com.example.lol.ui.fragment.home

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.lol.databinding.FragmentHomeBinding
import com.example.lol.domain.category.entity.CategoryEntity
import com.example.lol.ui.base.BaseFragment
import com.example.lol.ui.bottom_sheet.add_collection.AddCollectionFragment
import com.example.lol.ui.fragment.home.adapter.HomeAdapter
import com.example.lol.ui.utils.SwiPet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), AddCollectionFragment.Result,
    HomeAdapter.Result {
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var swipe: SwiPet
    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun setupUi() {
        initBtn()
        initAdapter()

    }

    private fun initSwipeListener() {
        swipe = object : SwiPet() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.adapterPosition
                val categoryEntity = homeAdapter.tempList[pos]
                viewModel.deleteCategory(categoryEntity)
            }
        }
    }

    private fun initAdapter() {
        homeAdapter = HomeAdapter(this)
        binding.rvHome.adapter = homeAdapter
    }

    override fun setupObservers() {
        initCategoryListener()
        initSwipeListener()
        initTouchListener()
    }

    private fun initTouchListener() {
        val itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(binding.rvHome)

    }

    private fun initCategoryListener() {
        viewModel.getAllCategory().flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { handleCategory(it) }.launchIn(lifecycleScope)
    }

    private fun handleCategory(list: List<CategoryEntity>) = homeAdapter.setList(list)


    private fun initBtn() {
        binding.contCollection.setOnClickListener {
            AddCollectionFragment(this).show(requireActivity().supportFragmentManager, "")
        }
    }

    override fun createCategory(category: String) =
        viewModel.createCategory(category)

    override fun categoryTran(category: String) {
        navigateToWord(category)
    }

    private fun navigateToWord(category: String) {
        val action = HomeFragmentDirections.actionHomeFragmentToWordFragment2(category)
        controller.navigate(action)
    }

}