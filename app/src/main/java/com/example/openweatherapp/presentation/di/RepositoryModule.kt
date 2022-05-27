package com.example.openweatherapp.presentation.di

import android.content.Context
import com.example.openweatherapp.data.api.WeatherAPIService
import com.example.openweatherapp.data.db.WeatherDatabase
import com.example.openweatherapp.data.repository.BookMarkRepositoryImpl
import com.example.openweatherapp.data.repository.CitiesRepositoryImpl
import com.example.openweatherapp.data.repository.WeatherRepositoryImpl
import com.example.openweatherapp.domain.repository.BookMarkRepository
import com.example.openweatherapp.domain.repository.CitiesRepository
import com.example.openweatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    fun provideCitiesRepository(context: Context): CitiesRepository {
        return CitiesRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideCityRepository(db: WeatherDatabase): BookMarkRepository {
        return BookMarkRepositoryImpl(db.getCityDAO())
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherAPIService): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}