package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.model.WeatherResponse
import com.example.openweatherapp.data.util.Resource
import com.example.openweatherapp.domain.repository.WeatherRepository

class GetWeatherUseCase (
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(id: Long, apiKey: String): Resource<WeatherResponse> {
        return weatherRepository.getWeatherReport(id, apiKey)
    }
}