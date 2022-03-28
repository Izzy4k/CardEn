package com.example.lol.data.word.storage

import com.example.lol.data.word.source.WordSource
import com.example.lol.domain.word.entity.WordEntity
import com.example.lol.domain.word.repo.WordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordStorage @Inject constructor(private val wordSource: WordSource) : WordRepository {
    override suspend fun createWord(word: String, category: String, image: String) =
        wordSource.createWord(WordEntity(0, word, category, image))

    override suspend fun deleteWord(wordEntity: WordEntity) = wordSource.deleteWord(wordEntity)

    override fun getWordsToCategory(categoryName: String): Flow<List<WordEntity>> =
        wordSource.getWordsToCategory(categoryName)

    override suspend fun deleteWords(listWordEntity: List<WordEntity>) =
        wordSource.deleteWords(listWordEntity)

    override suspend fun getListWordsToCategory(categoryName: String): List<WordEntity> =
        wordSource.getListWordsToCategory(categoryName)
}