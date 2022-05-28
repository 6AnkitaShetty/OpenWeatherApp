package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.data.model.City

interface BookMarkRepository {
    suspend fun getCities(): List<City>

    suspend fun getCityById(id: Long): City?

    suspend fun insertCity(city: City): Long?

    suspend fun deleteCity(city: City)
}