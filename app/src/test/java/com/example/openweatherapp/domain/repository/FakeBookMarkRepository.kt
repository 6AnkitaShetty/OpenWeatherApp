package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.data.db.CityEntity

class FakeBookMarkRepository: BookMarkRepository {

    private val cities = mutableListOf<CityEntity>()
    override suspend fun getCities(): List<CityEntity> {
       return cities
    }

    override suspend fun getCityById(id: Long): CityEntity? {
      return cities.find { it.cityId == id }
    }

    override suspend fun insertCity(cityEntity: CityEntity): Long {
        cities.add(cityEntity)
        return 0
    }

    override suspend fun deleteCity(cityEntity: CityEntity) {
        cities.remove(cityEntity)
    }
}