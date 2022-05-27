package com.example.openweatherapp.data.repository

import com.example.openweatherapp.data.db.CityDao
import com.example.openweatherapp.data.db.CityEntity
import com.example.openweatherapp.domain.repository.BookMarkRepository

class BookMarkRepositoryImpl (
    private val cityDao: CityDao
) : BookMarkRepository {
    override suspend fun getCities(): List<CityEntity> {
        return cityDao.getCities()
    }

    override suspend fun getCityById(id: Long): CityEntity? {
        return cityDao.getCityById(id)
    }

    override suspend fun insertCity(cityEntity: CityEntity): Long? {
        return cityDao.insertCity(cityEntity)
    }

    override suspend fun deleteCity(cityEntity: CityEntity) {
        cityDao.deleteCity(cityEntity)
    }

}