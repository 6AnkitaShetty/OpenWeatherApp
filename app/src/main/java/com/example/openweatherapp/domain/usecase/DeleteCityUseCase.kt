package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.db.CityEntity
import com.example.openweatherapp.domain.repository.BookMarkRepository

class DeleteCityUseCase(
    private val bookMarkRepository: BookMarkRepository
) {
    suspend operator fun invoke(cityEntity: CityEntity): Long {
        bookMarkRepository.deleteCity(cityEntity)
        return 0
    }
}