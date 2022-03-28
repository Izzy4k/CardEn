package com.example.lol.domain.word.use_cases

import com.example.lol.domain.word.entity.WordEntity
import com.example.lol.domain.word.repo.WordRepository
import javax.inject.Inject

class DeleteWordsUseCase @Inject constructor(private val wordRepository: WordRepository) {
    suspend fun deleteWords(listWords: List<WordEntity>) =
        wordRepository.deleteWords(listWords)
}