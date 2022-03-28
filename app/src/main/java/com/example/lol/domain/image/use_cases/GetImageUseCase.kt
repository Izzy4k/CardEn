package com.example.lol.domain.image.use_cases

import com.example.lol.domain.image.entity.Hit
import com.example.lol.domain.image.repo.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImageUseCase @Inject constructor(private val imageRepository: ImageRepository) {
   suspend  fun invoke(word: String): List<Hit> = imageRepository.getImage(word)
}
