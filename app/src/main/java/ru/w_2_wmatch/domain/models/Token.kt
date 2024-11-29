package ru.w_2_wmatch.domain.models

data class Token(
    val refresh : String,
    val access  : String,
)
