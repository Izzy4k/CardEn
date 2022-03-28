package com.example.lol.ui.dialog

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.view.View
import com.bumptech.glide.Glide
import com.example.lol.R
import com.example.lol.databinding.DialogPictureBinding

class FullDialog(private val activity: Activity) {
    private lateinit var dialog: Dialog
    private lateinit var binding: DialogPictureBinding

    init {
        createDialog()
    }

    private fun createDialog() {
        val builder = AlertDialog.Builder(activity)
        val view: View = activity.layoutInflater.inflate(R.layout.dialog_picture, null)
        builder.setView(view)
        dialog = builder.create()
        binding = DialogPictureBinding.bind(view)
    }

    fun open(image: String, word: String) {
        Glide.with(binding.imageFull).load(image).into(binding.imageFull)
        binding.dialogTxtWord.text = word
        initBtn()
        show()
    }

    private fun initBtn() {
        binding.btnClosed.setOnClickListener {
            dismiss()
        }
    }

    private fun show() {
        dialog.show()
    }


    private fun dismiss() {
        dialog.dismiss()
    }
}