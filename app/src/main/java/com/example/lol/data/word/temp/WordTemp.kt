package com.example.lol.data.word.temp

import com.example.lol.data.word.dao.WordDao
import com.example.lol.data.word.source.WordSource
import com.example.lol.domain.word.entity.WordEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordTemp @Inject constructor(private val wordDao: WordDao) : WordSource {
    override suspend fun createWord(wordEntity: WordEntity) = wordDao.createWord(wordEntity)

    override suspend fun deleteWord(wordEntity: WordEntity) = wordDao.deleteWord(wordEntity)

    override suspend fun deleteWords(listWordEntity: List<WordEntity>) =
        wordDao.deleteWords(listWordEntity)

    override fun getWordsToCategory(categoryName: String): Flow<List<WordEntity>> =
        wordDao.getWordToCategory(categoryName)

    override suspend fun getListWordsToCategory(categoryName: String): List<WordEntity> =
        wordDao.geListWordToCategory(categoryName)
}