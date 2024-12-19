package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.irepository.IQuestionnaireRepository
import ru.w_2_wmatch.domain.models.QuestionnaireChoicesItem

class GetQuestionnaireCategoriesApiUseCase(
    private val repository: IQuestionnaireRepository,
    private val getTokensPrefUseCase: GetTokensPrefUseCase,
    private val refreshTokenApiUseCase: RefreshTokenApiUseCase,
) {
    suspend operator fun invoke(): List<QuestionnaireChoicesItem> {

        /***Переписать нахер эту дичь. Самому стыдно
         * надо написать менеджер токенов с карутинами, состоянием внутри
         * положим в data слой*/

        var tokens = getTokensPrefUseCase()

        if (tokens.access.isNullOrEmpty() && tokens.refresh.isNullOrEmpty()) {
            //после авторизации сюда не должен зайти код
            //refresh токен срок две недели
            //выход на авторизацию
            return emptyList()
        }

        var result = repository.getQuestionnaireCategories(tokens.access)

        if (result.isSuccess) {
            val categories = result.getOrNull()
            if (categories != null) {
                return categories
            }
        } else {
            if (tokens.refresh != null) {
                if (refreshTokenApiUseCase(tokens.refresh)){
                    tokens = getTokensPrefUseCase()
                    result = repository.getQuestionnaireCategories(tokens.access)
                    if (result.isSuccess) {
                        val categories = result.getOrNull()
                        if (categories != null) {
                            return categories
                        }
                    } else return emptyList()
                } else return emptyList()
            }
        }

        return emptyList()
    }
}