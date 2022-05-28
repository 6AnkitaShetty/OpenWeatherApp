package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.data.db.CityEntity

interface BookMarkRepository {
    suspend fun getCities(): List<CityEntity>

    suspend fun getCityById(id: Long): CityEntity?

    suspend fun insertCity(cityEntity: CityEntity): Long?

    suspend fun deleteCity(cityEntity: CityEntity)
}