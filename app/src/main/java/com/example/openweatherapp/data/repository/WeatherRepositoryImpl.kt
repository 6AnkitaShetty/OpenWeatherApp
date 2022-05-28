package com.example.openweatherapp.data.repository

import com.example.openweatherapp.data.api.WeatherAPIService
import com.example.openweatherapp.data.model.WeatherResponse
import com.example.openweatherapp.data.util.Resource
import com.example.openweatherapp.domain.repository.WeatherRepository
import retrofit2.Response

class WeatherRepositoryImpl(
    private val weatherAPIService: WeatherAPIService
) : WeatherRepository {

    override suspend fun getWeatherReport(id: Long, apiKey: String): Resource<WeatherResponse> {
        return responseToResource(weatherAPIService.getWeather(id, apiKey))
    }

    private fun responseToResource(response: Response<WeatherResponse>): Resource<WeatherResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

}
