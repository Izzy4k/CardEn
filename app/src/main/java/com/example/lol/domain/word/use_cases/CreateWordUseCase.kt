package com.example.lol.domain.word.use_cases

import com.example.lol.domain.word.repo.WordRepository
import javax.inject.Inject

class CreateWordUseCase @Inject constructor(private val wordRepository: WordRepository) {
    suspend fun createWord(word: String, category: String, image: String) =
        wordRepository.createWord(word, category, image)

}