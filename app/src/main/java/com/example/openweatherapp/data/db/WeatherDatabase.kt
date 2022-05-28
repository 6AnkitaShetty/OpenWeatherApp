package com.example.openweatherapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.openweatherapp.data.model.City

@Database(entities = [City::class], version = 1)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun getCityDAO(): CityDao

    companion object {
        const val DATABASE_NAME = "weather_db"
    }
}