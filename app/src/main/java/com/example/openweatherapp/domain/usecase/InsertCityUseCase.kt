package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.repository.BookMarkRepository

class InsertCityUseCase(
    private val bookMarkRepository: BookMarkRepository
) {
    suspend operator fun invoke(city: City): Long? {
        return bookMarkRepository.insertCity(city)
    }
}