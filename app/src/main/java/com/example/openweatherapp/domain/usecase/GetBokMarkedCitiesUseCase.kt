package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.db.CityEntity
import com.example.openweatherapp.domain.repository.BookMarkRepository

class GetBokMarkedCitiesUseCase(
    private val bookMarkRepository: BookMarkRepository
) {
    suspend operator fun invoke(
    ): List<CityEntity> {
        return bookMarkRepository.getCities()
    }
}