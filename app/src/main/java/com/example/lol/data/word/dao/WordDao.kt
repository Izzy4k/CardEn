package com.example.lol.data.word.dao

import androidx.room.*
import com.example.lol.domain.word.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWord(wordEntity: WordEntity)

    @Delete
    suspend fun deleteWord(wordEntity: WordEntity)

    @Delete
    suspend fun deleteWords(listWord: List<WordEntity>)

    @Query("SELECT * FROM word_entity WHERE category=:categoryName")
    fun getWordToCategory(categoryName: String): Flow<List<WordEntity>>

    @Query("SELECT * FROM word_entity WHERE category=:categoryName")
    suspend fun geListWordToCategory(categoryName: String): List<WordEntity>
}