package com.example.lol.data.word.module

import com.example.lol.data.common.module.local.DataBaseModule
import com.example.lol.data.common.room.AppDataBase
import com.example.lol.data.word.dao.WordDao
import com.example.lol.data.word.source.WordSource
import com.example.lol.data.word.storage.WordStorage
import com.example.lol.data.word.temp.WordTemp
import com.example.lol.domain.word.repo.WordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DataBaseModule::class])
@InstallIn(SingletonComponent::class)
class WordModule {
    @Provides
    fun createWordDao(appDataBase: AppDataBase): WordDao = appDataBase.getWordDao()

    @Provides
    fun createWordSource(wordDao: WordDao): WordSource = WordTemp(wordDao)

    @Provides

    fun createWordRepo(wordSource: WordSource): WordRepository = WordStorage(wordSource)
}