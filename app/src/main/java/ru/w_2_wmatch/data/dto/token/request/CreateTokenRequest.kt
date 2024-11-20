package ru.w_2_wmatch.data.dto.token.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateTokenRequest (
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
)