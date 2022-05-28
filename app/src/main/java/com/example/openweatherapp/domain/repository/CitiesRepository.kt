package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.data.model.City

interface CitiesRepository {
    suspend fun getCities(): List<City>?
}