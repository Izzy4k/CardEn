package com.example.lol.ui.bottom_sheet.add_collection

import com.example.lol.databinding.FragmentAddCollectionBinding
import com.example.lol.ui.base.BaseFragmentBottomSheet

class AddCollectionFragment(private val result: Result) :
    BaseFragmentBottomSheet<FragmentAddCollectionBinding>() {
    override fun getViewBinding(): FragmentAddCollectionBinding =
        FragmentAddCollectionBinding.inflate(layoutInflater)

    override fun setupUi() {
        initBtn()
    }

    private fun initBtn() {
        binding.categoryBtn.setOnClickListener {
            val word = binding.editCategory.text.toString()
            if (word.isNotBlank()) {
                result.createCategory(word)
                dismiss()
            }
        }
    }


    override fun setupObservers() {
    }


    interface Result {
        fun createCategory(category: String)
    }
}