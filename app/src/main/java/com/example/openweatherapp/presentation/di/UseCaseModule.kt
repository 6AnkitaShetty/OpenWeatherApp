package com.example.openweatherapp.presentation.di

import com.example.openweatherapp.domain.repository.BookMarkRepository
import com.example.openweatherapp.domain.repository.CitiesRepository
import com.example.openweatherapp.domain.repository.WeatherRepository
import com.example.openweatherapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideCitiesUseCases(citiesRepository: CitiesRepository): GetCitiesUseCase {
        return GetCitiesUseCase(citiesRepository)
    }

    @Provides
    @Singleton
    fun provideBookMarkedUseCases(bookMarkRepository: BookMarkRepository): BookMarkedUseCase {
        return BookMarkedUseCase(
            bookMarkCityUseCase = BookMarkCityUseCase(bookMarkRepository),
            getBokMarkedCitiesUseCase = GetBokMarkedCitiesUseCase(bookMarkRepository),
            deleteCityUseCase = DeleteCityUseCase(bookMarkRepository),
            insertCityUseCase = InsertCityUseCase(bookMarkRepository)
        )
    }

    @Provides
    @Singleton
    fun provideWeatherUseCases(weatherRepository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(weatherRepository)
    }
}