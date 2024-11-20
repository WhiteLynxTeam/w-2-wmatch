package ru.w_2_wmatch.domain.models

data class Token(
    val refresh : String? = null,
    val access  : String? = null
)
