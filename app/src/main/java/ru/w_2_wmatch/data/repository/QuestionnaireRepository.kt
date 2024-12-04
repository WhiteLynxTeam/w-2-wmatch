package ru.w_2_wmatch.data.repository

import ru.w_2_wmatch.data.api.QuestionnaireApi
import ru.w_2_wmatch.data.dto.questionnaire.response.QuestionnaireChoicesResponse
import ru.w_2_wmatch.domain.irepository.IQuestionnaireRepository
import ru.w_2_wmatch.domain.models.QuestionnaireChoicesItem

class QuestionnaireRepository(
    private val questionnaireApi: QuestionnaireApi,
) : IQuestionnaireRepository {

    override suspend fun getQuestionnaireCategories(accessToken: String): Result<List<QuestionnaireChoicesItem>> {
        val result = questionnaireApi.get(token = "Bearer $accessToken")

        println("QuestionnaireRepository - getQuestionnaireCategories: result = $result")

        return result.map { mapperQuestionnaireChoicesResponseToQuestionnaireCategories(it) }
    }

    private fun mapperQuestionnaireChoicesResponseToQuestionnaireCategories(
        questionnaireChoicesResponse: QuestionnaireChoicesResponse
    ): List<QuestionnaireChoicesItem> {
        return questionnaireChoicesResponse.categories.map {
            QuestionnaireChoicesItem(
                id = it.id,
                name = it.name
            )
        }
    }
}