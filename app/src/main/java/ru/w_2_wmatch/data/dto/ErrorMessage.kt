package ru.w_2_wmatch.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorMessage(
    @SerialName("token_class") val token_class: String? = null,
    @SerialName("token_type") val token_type: String? = null,
    @SerialName("message") val message: String? = null,
)