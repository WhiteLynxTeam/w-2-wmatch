package ru.w_2_wmatch.domain.models

data class RecommendedBrands(
    val img: Int,
    val brandName: String,
    val icGeo: Int,
    val city: String,
    val icSubscribes: Int,
    val subscribes: String
)
