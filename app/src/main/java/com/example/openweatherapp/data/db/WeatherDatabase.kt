package com.example.openweatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CityEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun getCityDAO(): CityDao

    companion object {
        const val DATABASE_NAME = "weather_db"
    }
}