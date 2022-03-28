package com.example.lol.ui.fragment.word.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lol.databinding.ItemWordBinding
import com.example.lol.domain.word.entity.WordEntity

class WordAdapter(private val result: Result) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    private var listWords: List<WordEntity> = ArrayList()
    val listTemp: List<WordEntity> get() = listWords

    fun setList(list: List<WordEntity>) {
        listWords = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = ItemWordBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return WordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.onBind(listWords[position].word, listWords[position].image)
        holder.itemView.setOnClickListener {
            result.openDialog(listWords[position].image, listWords[position].word)
        }
    }

    override fun getItemCount(): Int =
        listWords.size

    inner class WordViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(word: String, image: String) {
            binding.itemTxtTitle.text = word
            Glide.with(binding.itemImage).load(image).into(binding.itemImage)
        }
    }

    interface Result {
        fun openDialog(image: String, title: String)
    }
}