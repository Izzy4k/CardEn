package com.example.lol.data.category.source

import com.example.lol.domain.category.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface CategorySource {
    suspend fun createCategory(category: CategoryEntity)
    suspend fun deleteCategory(category: CategoryEntity)
    fun getAllCategory(): Flow<List<CategoryEntity>>
}