package com.example.lol.data.common.module.local

import android.content.Context
import androidx.room.Room
import com.example.lol.data.common.room.AppDataBase
import com.example.lol.data.common.utils.EndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun getRoom(@ApplicationContext context: Context): AppDataBase =
        Room.databaseBuilder(context, AppDataBase::class.java, EndPoints.NAME_DATA_BASE)
            .build()
}