package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.repository.BookMarkRepository

class DeleteCityUseCase(
    private val bookMarkRepository: BookMarkRepository
) {
    suspend operator fun invoke(city: City): Long {
        bookMarkRepository.deleteCity(city)
        return 0
    }
}