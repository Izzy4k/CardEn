package com.example.lol.domain.word.repo

import com.example.lol.domain.word.entity.WordEntity
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    suspend fun createWord(word: String, category: String, image: String)
    suspend fun deleteWord(wordEntity: WordEntity)
    fun getWordsToCategory(categoryName: String): Flow<List<WordEntity>>
    suspend fun deleteWords(listWordEntity: List<WordEntity>)
    suspend fun getListWordsToCategory(categoryName: String): List<WordEntity>
}