package com.example.lol.data.category.dao

import androidx.room.*
import com.example.lol.domain.category.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createCategory(vararg category: CategoryEntity)

    @Delete
    suspend fun deleteCategory(vararg categoryEntity: CategoryEntity)

    @Query("SELECT * FROM category_entity")
    fun getAllCategory(): Flow<List<CategoryEntity>>
}