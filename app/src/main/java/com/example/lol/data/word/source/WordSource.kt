package com.example.lol.data.word.source

import com.example.lol.domain.word.entity.WordEntity
import kotlinx.coroutines.flow.Flow

interface WordSource {
    suspend fun createWord(wordEntity: WordEntity)
    suspend fun deleteWord(wordEntity: WordEntity)
    suspend fun deleteWords(listWordEntity: List<WordEntity>)
    fun getWordsToCategory(categoryName: String): Flow<List<WordEntity>>
    suspend fun getListWordsToCategory(categoryName: String): List<WordEntity>
}