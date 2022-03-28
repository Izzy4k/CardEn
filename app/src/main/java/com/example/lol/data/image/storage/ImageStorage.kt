package com.example.lol.data.image.storage

import com.example.lol.data.common.utils.EndPoints
import com.example.lol.data.image.remote.ImageApi
import com.example.lol.domain.image.entity.Hit
import com.example.lol.domain.image.repo.ImageRepository
import javax.inject.Inject

class ImageStorage @Inject constructor(private val imageApi: ImageApi) : ImageRepository {
    override suspend fun getImage(word: String): List<Hit> {
        val response = imageApi.getImage(EndPoints.KEY, word)
        if (response.isSuccessful) {
            val body = response.body()
            return body?.hits!!
        }
        return emptyList()
    }
}