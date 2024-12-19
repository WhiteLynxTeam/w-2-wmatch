package ru.w_2_wmatch.view.questionnaire.brand_position

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.w_2_wmatch.domain.AppState
import ru.w_2_wmatch.domain.models.Brand
import ru.w_2_wmatch.domain.models.QuestionnaireChoicesItem
import ru.w_2_wmatch.domain.usecases.GetQuestionnaireCategoriesApiUseCase
import ru.w_2_wmatch.domain.usecases.SaveBrandPrefUseCase

class BrandPositionViewModel(
    private val saveBrandPrefUseCase: SaveBrandPrefUseCase,
    private val getQuestionnaireCategoriesApiUseCase: GetQuestionnaireCategoriesApiUseCase,
): ViewModel() {
    private val _appStateFlow = MutableStateFlow<AppState>(AppState.None)
    val appStateFlow: StateFlow<AppState> = _appStateFlow

    private val _categories = MutableStateFlow<List<QuestionnaireChoicesItem>>(emptyList())
    val categories: StateFlow<List<QuestionnaireChoicesItem>> = _categories

    init {
        getCategories()
    }

    fun getCategories() {
        viewModelScope.launch {
            _categories.emit(getQuestionnaireCategoriesApiUseCase())
        }
    }

    fun saveAnswer(brand: Brand) {
        viewModelScope.launch {
            _appStateFlow.emit(AppState.Loading)
            _appStateFlow.emit(AppState.Success(saveBrandPrefUseCase(brand)))
        }
    }

    class Factory(
        private val saveBrandPrefUseCase: SaveBrandPrefUseCase,
        private val getQuestionnaireCategoriesApiUseCase: GetQuestionnaireCategoriesApiUseCase,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BrandPositionViewModel::class.java)) {
                return BrandPositionViewModel(
                    saveBrandPrefUseCase = saveBrandPrefUseCase,
                    getQuestionnaireCategoriesApiUseCase = getQuestionnaireCategoriesApiUseCase,
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}