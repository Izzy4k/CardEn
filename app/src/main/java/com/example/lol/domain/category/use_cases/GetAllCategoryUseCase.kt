package com.example.lol.domain.category.use_cases

import com.example.lol.domain.category.entity.CategoryEntity
import com.example.lol.domain.category.repo.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCategoryUseCase @Inject constructor(private val categoryRepository: CategoryRepository) {
    fun invoke(): Flow<List<CategoryEntity>> = categoryRepository.getAllCategory()
}