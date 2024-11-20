package ru.w_2_wmatch.utils

// проверка Email на корректность
fun String.isEmailValid(): Boolean {
    val emailRegex = Regex("^([A-Za-z0-9._%+-]+)@([A-Za-z0-9-]+)\\.([A-Za-z]{2,})$")
    return emailRegex.matches(this)
}