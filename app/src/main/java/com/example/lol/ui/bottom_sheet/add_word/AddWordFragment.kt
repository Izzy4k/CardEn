package com.example.lol.ui.bottom_sheet.add_word

import android.text.Editable
import android.text.TextWatcher
import com.example.lol.databinding.FragmentAddWordBinding
import com.example.lol.ui.base.BaseFragmentBottomSheet
import java.util.*

class AddWordFragment(private val result: Result) :
    BaseFragmentBottomSheet<FragmentAddWordBinding>() {

    override fun getViewBinding(): FragmentAddWordBinding =
        FragmentAddWordBinding.inflate(layoutInflater)

    override fun setupUi() {
    }

    override fun setupObservers() {
        initListenerEdit()
    }

    private fun initListenerEdit() {
        val interval: Long = 2000
        var timer = Timer()
        binding.editCategory.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                timer.cancel()
            }

            override fun afterTextChanged(p0: Editable?) {
                timer.cancel()
                timer = Timer()
                timer.schedule(object : TimerTask() {
                    override fun run() {
                        val word = binding.editCategory.text.toString()
                        if (word.isNotBlank()) {
                            tag?.let { result.transNewWord(word, it) }
                            dismiss()
                        }
                    }
                }, interval)
            }

        })
    }

    interface Result {
        fun transNewWord(word: String, category: String)
    }
}