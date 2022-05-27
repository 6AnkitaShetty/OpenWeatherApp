package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.db.CityEntity
import com.example.openweatherapp.domain.repository.BookMarkRepository

class InsertCityUseCase (
    private val bookMarkRepository: BookMarkRepository
) {
    suspend operator fun invoke(cityEntity: CityEntity): Long? {
       return bookMarkRepository.insertCity(cityEntity)
    }
}