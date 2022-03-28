package com.example.lol.domain.image.repo

import com.example.lol.domain.image.entity.Hit
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    suspend fun getImage(word: String): List<Hit>
}