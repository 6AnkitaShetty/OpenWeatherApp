package com.example.openweatherapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "CityEntity")
data class CityEntity(
    @PrimaryKey
    val cityId: Long = -1,
    val cityName: String? = null,
    val state: String? = null,
    val country: String? = null,
    val lat: Double,
    val lon: Double
) : Serializable