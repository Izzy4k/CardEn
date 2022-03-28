package com.example.lol.domain.category.repo

import com.example.lol.domain.category.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface CategoryRepository {
    suspend fun createCategory(category: String)
    suspend fun deleteCategory(category: CategoryEntity)
    fun getAllCategory(): Flow<List<CategoryEntity>>
}