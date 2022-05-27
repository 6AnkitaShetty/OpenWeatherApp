package com.example.openweatherapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.openweatherapp.data.db.CityDao
import com.example.openweatherapp.data.db.WeatherDatabase
import com.example.openweatherapp.data.db.WeatherDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideWeatherDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(
            app,
            WeatherDatabase::class.java,
            DATABASE_NAME
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideCityDao(weatherDatabase: WeatherDatabase): CityDao {
        return weatherDatabase.getCityDAO()
    }
}