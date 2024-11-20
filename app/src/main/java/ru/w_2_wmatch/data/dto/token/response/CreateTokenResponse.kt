package ru.w_2_wmatch.data.dto.token.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateTokenResponse(
    @SerialName("refresh") val refresh: String,
    @SerialName("access") val access: String,
)