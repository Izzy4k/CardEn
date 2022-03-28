package com.example.lol.data.category.module

import com.example.lol.data.category.dao.CategoryDao
import com.example.lol.data.category.source.CategorySource
import com.example.lol.data.category.storage.CategoryStorage
import com.example.lol.data.category.temp.CategoryTemp
import com.example.lol.data.common.module.local.DataBaseModule
import com.example.lol.data.common.room.AppDataBase
import com.example.lol.domain.category.repo.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DataBaseModule::class])
@InstallIn(SingletonComponent::class)
class CategoryModule {

    @Provides
    fun createCategoryDao(appDataBase: AppDataBase): CategoryDao =
        appDataBase.getCategoryDao()

    @Provides
    fun createCategorySource(categoryDao: CategoryDao): CategorySource =
        CategoryTemp(categoryDao)

    @Provides
    fun createCategoryRepo(categorySource: CategorySource): CategoryRepository =
        CategoryStorage(categorySource)
}