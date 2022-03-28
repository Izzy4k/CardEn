package com.example.lol.domain.category.use_cases

import com.example.lol.domain.category.repo.CategoryRepository
import javax.inject.Inject

class CreateCategoryUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {
    suspend fun createCategory(category: String) =
        categoryRepository.createCategory(category)
}