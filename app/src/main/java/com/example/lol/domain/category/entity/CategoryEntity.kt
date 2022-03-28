package com.example.lol.domain.category.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_entity")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: String
)