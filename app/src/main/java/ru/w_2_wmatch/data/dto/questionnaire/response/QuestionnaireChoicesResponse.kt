package ru.w_2_wmatch.data.dto.questionnaire.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.w_2_wmatch.data.dto.questionnaire.QuestionnaireItem

@Serializable
data class QuestionnaireChoicesResponse(
    @SerialName("categories") val categories: List<QuestionnaireItem>,
    @SerialName("tags") val tags: List<QuestionnaireItem>,
    @SerialName("formats") val formats: List<QuestionnaireItem>,
    @SerialName("goals") val goals: List<QuestionnaireItem>,
)