package com.example.lol.data.common.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lol.data.category.dao.CategoryDao
import com.example.lol.data.word.dao.WordDao
import com.example.lol.domain.category.entity.CategoryEntity
import com.example.lol.domain.word.entity.WordEntity

@Database(entities = [CategoryEntity::class, WordEntity::class], version = 2)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getWordDao(): WordDao
}