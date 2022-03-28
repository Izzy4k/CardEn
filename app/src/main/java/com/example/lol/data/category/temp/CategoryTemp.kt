package com.example.lol.data.category.temp

import com.example.lol.data.category.dao.CategoryDao
import com.example.lol.data.category.source.CategorySource
import com.example.lol.domain.category.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class CategoryTemp @Inject constructor(private val categoryDao: CategoryDao) : CategorySource {
    override suspend fun createCategory(category: CategoryEntity) =
        categoryDao.createCategory(category)

    override suspend fun deleteCategory(category: CategoryEntity) =
        categoryDao.deleteCategory(category)

    override fun getAllCategory(): Flow<List<CategoryEntity>> =
        categoryDao.getAllCategory()
}