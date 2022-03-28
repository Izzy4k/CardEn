package com.example.lol.domain.word.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_entity")
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var word: String,
    val category: String,
    val image: String
)
