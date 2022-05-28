package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.repository.CitiesRepository

class GetCitiesUseCase(
    private val citiesRepository: CitiesRepository
) {
    suspend operator fun invoke(): List<City>? {
        return citiesRepository.getCities()
    }
}