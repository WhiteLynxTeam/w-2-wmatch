package ru.w_2_wmatch.data.api

import retrofit2.http.Header
import retrofit2.http.POST
import ru.w_2_wmatch.data.dto.questionnaire.response.QuestionnaireChoicesResponse

interface QuestionnaireApi {
    @POST("/api/v1/questionnaire_choices/")
    suspend fun get(
        @Header("Authorization") token: String,
    ): Result<QuestionnaireChoicesResponse>
}
