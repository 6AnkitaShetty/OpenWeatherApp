package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.repository.BookMarkRepository

class BookMarkCityUseCase(
    private val bookMarkRepository: BookMarkRepository
) {
    suspend operator fun invoke(city: City): Long? {
        val cityByID = bookMarkRepository.getCityById(city.id)
        return if (cityByID != null) {
            bookMarkRepository.deleteCity(city)
            0
        } else {
            bookMarkRepository.insertCity(city)
        }
    }
}