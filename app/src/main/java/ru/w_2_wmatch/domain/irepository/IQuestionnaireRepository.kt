package ru.w_2_wmatch.domain.irepository

import ru.w_2_wmatch.domain.models.QuestionnaireChoicesItem

interface IQuestionnaireRepository {
    suspend fun getQuestionnaireCategories(accessToken: String): Result<List<QuestionnaireChoicesItem>>
}