package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.repository.BookMarkRepository

class GetBokMarkedCitiesUseCase(
    private val bookMarkRepository: BookMarkRepository
) {
    suspend operator fun invoke(
    ): List<City> {
        return bookMarkRepository.getCities()
    }
}