package com.example.openweatherapp.data.repository

import com.example.openweatherapp.data.db.CityDao
import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.repository.BookMarkRepository

class BookMarkRepositoryImpl(
    private val cityDao: CityDao
) : BookMarkRepository {
    override suspend fun getCities(): List<City> {
        return cityDao.getCities()
    }

    override suspend fun getCityById(id: Long): City? {
        return cityDao.getCityById(id)
    }

    override suspend fun insertCity(city: City): Long? {
        return cityDao.insertCity(city)
    }

    override suspend fun deleteCity(city: City) {
        cityDao.deleteCity(city)
    }

}