package ru.w_2_wmatch.data.dto.user.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    @SerialName("fullname") val fullname: String,
    @SerialName("email") val email: String,
    @SerialName("phone") val phone: String,
    @SerialName("password") val password: String,
)
