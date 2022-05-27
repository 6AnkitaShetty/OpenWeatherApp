package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.repository.CitiesRepository
import kotlinx.coroutines.flow.Flow

class GetCitiesUseCase (
    private val citiesRepository: CitiesRepository
) {
    suspend operator fun invoke(): List<City>? {
        return citiesRepository.getCities()
    }
}