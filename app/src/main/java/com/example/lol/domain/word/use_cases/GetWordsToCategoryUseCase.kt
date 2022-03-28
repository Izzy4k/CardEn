package com.example.lol.domain.word.use_cases

import com.example.lol.domain.word.entity.WordEntity
import com.example.lol.domain.word.repo.WordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWordsToCategoryUseCase @Inject constructor(private val wordRepository: WordRepository) {
    fun invoke(category: String): Flow<List<WordEntity>> =
        wordRepository.getWordsToCategory(category)
}