package com.example.lol.ui.fragment.word

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lol.domain.category.use_cases.GetAllCategoryUseCase
import com.example.lol.domain.image.use_cases.GetImageUseCase
import com.example.lol.domain.word.entity.WordEntity
import com.example.lol.domain.word.use_cases.CreateWordUseCase
import com.example.lol.domain.word.use_cases.DeleteWordUseCase
import com.example.lol.domain.word.use_cases.GetWordsToCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordViewModel
@Inject
constructor(
    private val createWordUseCase: CreateWordUseCase,
    private val deleteWordUseCase: DeleteWordUseCase,
    private val getAllWordUseCase: GetWordsToCategoryUseCase,
    private val imageUseCase: GetImageUseCase
) : ViewModel() {

    fun createWord(word: String, category: String) {
        viewModelScope.launch {
            val image = imageUseCase.invoke(word)[0].largeImageURL
            createWordUseCase.createWord(word, category, image)
        }
    }


    fun getAllWordToCategory(category: String): Flow<List<WordEntity>> =
        getAllWordUseCase.invoke(category)

    fun deleteWord(wordEntity: WordEntity) {
        viewModelScope.launch {
            deleteWordUseCase.deleteWord(wordEntity)
        }
    }
}
