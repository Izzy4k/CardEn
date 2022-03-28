package com.example.lol.domain.word.use_cases

import com.example.lol.domain.word.entity.WordEntity
import com.example.lol.domain.word.repo.WordRepository
import javax.inject.Inject

class DeleteWordUseCase @Inject constructor(private val wordRepository: WordRepository) {
    suspend fun deleteWord(wordEntity: WordEntity) =
        wordRepository.deleteWord(wordEntity)
}