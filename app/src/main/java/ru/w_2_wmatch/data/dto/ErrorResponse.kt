package ru.w_2_wmatch.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    @SerialName("detail") val detail: String? = null,
    @SerialName("code") val access: String? = null,
    @SerialName("messages") val messages: List<ErrorMessage>? = null,
)