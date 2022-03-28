package com.example.lol.ui.fragment.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lol.databinding.ItemCategoryBinding
import com.example.lol.domain.category.entity.CategoryEntity

class HomeAdapter(private val result: Result) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var list: List<CategoryEntity> = ArrayList()
    val tempList: List<CategoryEntity> get() = list
    fun setList(list: List<CategoryEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return HomeViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(list[position].category)
        holder.itemView.setOnClickListener {
            result.categoryTran(list[position].category)
        }
    }

    override fun getItemCount(): Int =
        list.size

    inner class HomeViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(category: String) {
            binding.itemTxtCategory.text = category
        }
    }

    interface Result {
        fun categoryTran(category: String)
    }
}

