package com.example.lol.data.image.module

import com.example.lol.data.common.module.network.NetworkModule
import com.example.lol.data.image.remote.ImageApi
import com.example.lol.data.image.storage.ImageStorage
import com.example.lol.domain.image.repo.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class ImageModule {

    @Provides
    @Singleton
    fun getImageApi(retrofit: Retrofit): ImageApi {
        return retrofit.create(ImageApi::class.java)
    }

    @Provides
    @Singleton
    fun getImageRepo(imageApi: ImageApi): ImageRepository {
        return ImageStorage(imageApi)
    }
}