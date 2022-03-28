package com.example.lol.data.image.remote

import com.example.lol.data.common.utils.EndPoints
import com.example.lol.domain.image.entity.ImageEntity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET(EndPoints.API)
    suspend fun getImage(
        @Query(EndPoints.APP_KEY) key: String,
        @Query(EndPoints.Q) word: String,
        @Query(EndPoints.PAGE) page: Int = EndPoints.ONE,
        @Query(EndPoints.LIMIT) limit: Int = EndPoints.TEN
    ): Response<ImageEntity>
}