package ru.w_2_wmatch.data.dto.questionnaire

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionnaireItem(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
)