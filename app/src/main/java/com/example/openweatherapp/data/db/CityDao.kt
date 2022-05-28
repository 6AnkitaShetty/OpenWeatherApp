package com.example.openweatherapp.data.db

import androidx.room.*
import com.example.openweatherapp.data.model.City

@Dao
interface CityDao {

    @Query("SELECT * FROM City")
    suspend fun getCities(): List<City>

    @Query("SELECT * FROM City WHERE id=:id")
    suspend fun getCityById(id: Long): City?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: City): Long?

    @Delete
    suspend fun deleteCity(city: City)
}