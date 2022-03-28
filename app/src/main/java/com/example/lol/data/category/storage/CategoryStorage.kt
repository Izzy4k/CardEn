package com.example.lol.data.category.storage

import com.example.lol.data.category.source.CategorySource
import com.example.lol.domain.category.entity.CategoryEntity
import com.example.lol.domain.category.repo.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryStorage constructor(private val categorySource: CategorySource) : CategoryRepository {
    override suspend fun createCategory(category: String) =
        categorySource.createCategory(CategoryEntity(0, category))

    override suspend fun deleteCategory(category: CategoryEntity) =
        categorySource.deleteCategory(category)

    override fun getAllCategory(): Flow<List<CategoryEntity>> =
        categorySource.getAllCategory()

}