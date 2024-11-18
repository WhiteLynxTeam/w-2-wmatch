package ru.w_2_wmatch.data.dto.user.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    @SerialName("id") val id: Int,
    @SerialName("fullname") val fullname: String,
    @SerialName("email") val email: String,
    @SerialName("phone") val phone: String,
 )
