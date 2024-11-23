package ru.w_2_wmatch.domain.models

data class User(
    val fullname: String,
    val email: String,
    val phone: String,
    val password: String? = null,
)