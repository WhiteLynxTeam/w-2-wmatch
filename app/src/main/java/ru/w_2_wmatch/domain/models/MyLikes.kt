package ru.w_2_wmatch.domain.models

data class MyLikes(
    val img: Int,
    val title: String,
    val description: String,
    val avatar: Int,
    val userName: String,
    val icGeo: Int,
    val city: String,
    val icSubscribes: Int,
    val subscribes: String
)
