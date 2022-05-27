package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.data.model.City
import kotlinx.coroutines.flow.Flow

interface CitiesRepository {
    suspend fun getCities() : List<City>?
}