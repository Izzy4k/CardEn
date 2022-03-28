package com.example.lol.ui.fragment.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lol.domain.category.entity.CategoryEntity
import com.example.lol.domain.category.use_cases.CreateCategoryUseCase
import com.example.lol.domain.category.use_cases.DeleteCategoryUseCase
import com.example.lol.domain.category.use_cases.GetAllCategoryUseCase
import com.example.lol.domain.word.use_cases.DeleteWordsUseCase
import com.example.lol.domain.word.use_cases.GetListWordsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createCategoryUseCase: CreateCategoryUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase,
    private val getAllCategoryUseCase: GetAllCategoryUseCase,
    private val deleteWordsUseCase: DeleteWordsUseCase,
    private val getListWordsUseCase: GetListWordsUseCase
) : ViewModel() {

    fun getAllCategory(): Flow<List<CategoryEntity>> = getAllCategoryUseCase.invoke()

    fun createCategory(categoryEntity: String) {
        viewModelScope.launch {
            createCategoryUseCase.createCategory(categoryEntity)
        }
    }

    fun deleteCategory(categoryEntity: CategoryEntity) {
        viewModelScope.launch {
            deleteCategoryUseCase.deleteCategory(categoryEntity)
            deleteWordsToCategory(categoryEntity.category)
        }
    }

    private fun deleteWordsToCategory(category: String) {
        viewModelScope.launch {
            deleteWordsUseCase.deleteWords(getListWordsUseCase.getListWords(category))
        }
    }

}