package ru.w_2_wmatch.domain.istorage

import ru.w_2_wmatch.domain.models.Brand

interface IBrandStorage {
    fun save(brand: Brand)
    fun get(): Brand
}
