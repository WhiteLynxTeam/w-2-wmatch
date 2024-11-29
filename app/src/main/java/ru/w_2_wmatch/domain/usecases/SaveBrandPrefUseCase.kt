package ru.w_2_wmatch.domain.usecases

import ru.w_2_wmatch.domain.istorage.IBrandStorage
import ru.w_2_wmatch.domain.models.Brand

class SaveBrandPrefUseCase(
    private val storage: IBrandStorage
) {
    operator fun invoke(brand: Brand): Boolean {
        storage.save(brand)
        return true
    }
}