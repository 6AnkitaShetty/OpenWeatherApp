package com.example.openweatherapp.data.db

import androidx.room.*
@Dao
interface CityDao {

    @Query("SELECT * FROM CityEntity")
    suspend fun getCities(): List<CityEntity>

    @Query("SELECT * FROM CityEntity WHERE cityId=:id")
    suspend fun getCityById(id :Long) : CityEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(cityEntity: CityEntity) : Long?

    @Delete
    suspend fun deleteCity(cityEntity: CityEntity)
}