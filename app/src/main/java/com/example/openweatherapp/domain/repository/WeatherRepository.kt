package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.data.model.WeatherResponse
import com.example.openweatherapp.data.util.Resource

interface WeatherRepository {
    suspend fun getWeatherReport(id: Long, apiKey: String) : Resource<WeatherResponse>
}