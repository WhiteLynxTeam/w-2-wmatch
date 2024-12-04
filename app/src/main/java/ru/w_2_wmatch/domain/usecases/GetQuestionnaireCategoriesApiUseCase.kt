package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.irepository.IQuestionnaireRepository
import ru.w_2_wmatch.domain.models.AuthUser
import ru.w_2_wmatch.domain.models.QuestionnaireChoicesItem

class GetQuestionnaireCategoriesApiUseCase(
    private val repository: IQuestionnaireRepository,
    private val getTokensPrefUseCase: GetTokensPrefUseCase,
    private val refreshTokenApiUseCase: RefreshTokenApiUseCase,
) {
    suspend operator fun invoke(): List<QuestionnaireChoicesItem> {

        val tokens = getTokensPrefUseCase()

        if (tokens.access.isNullOrEmpty() && tokens.refresh.isNullOrEmpty()) {
            //после авторизации сюда не должен зайти код
            //refresh токен срок две недели
            //выход на авторизацию
            return emptyList()
        }

        val result = repository.getQuestionnaireCategories(tokens.access)

        if (result.isSuccess) {
            val categories = result.getOrNull()
            if (categories != null) {
                return categories
            }
        } else {
            if (tokens.refresh != null) {

            }
        }

//        val result = tokens.access?.let { repository.getQuestionnaireCategories(it) }
        /*if (result.isSuccess) {
            val token = result.getOrNull()
            if (token != null) {
                saveTokenPrefUseCase(token)
                return true
            }
        }
        return false
    }*/
        return emptyList()
    }
}