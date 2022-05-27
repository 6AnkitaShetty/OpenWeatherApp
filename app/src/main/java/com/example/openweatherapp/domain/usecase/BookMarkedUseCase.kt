package com.example.openweatherapp.domain.usecase

data class BookMarkedUseCase(
    val bookMarkCityUseCase: BookMarkCityUseCase,
    val getBokMarkedCitiesUseCase: GetBokMarkedCitiesUseCase,
    val deleteCityUseCase:DeleteCityUseCase,
    val insertCityUseCase:InsertCityUseCase
)


