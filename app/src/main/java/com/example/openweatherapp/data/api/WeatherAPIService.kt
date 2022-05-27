package com.example.openweatherapp.data.api

import com.example.openweatherapp.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {
    @GET("weather")
    suspend fun getWeather(
        @Query("id") id: Long,
        @Query("apikey") apikey: String
    ): Response<WeatherResponse>
}