package com.example.lol.domain.category.use_cases

import com.example.lol.domain.category.entity.CategoryEntity
import com.example.lol.domain.category.repo.CategoryRepository
import javax.inject.Inject

class DeleteCategoryUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {
    suspend fun deleteCategory(categoryEntity: CategoryEntity) =
        categoryRepository.deleteCategory(categoryEntity)
}