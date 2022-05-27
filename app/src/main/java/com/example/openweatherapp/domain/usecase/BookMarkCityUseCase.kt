package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.db.CityEntity
import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.repository.BookMarkRepository

class BookMarkCityUseCase(
    private val bookMarkRepository: BookMarkRepository
) {
    suspend operator fun invoke(city: City): Long? {
        val cityByID = bookMarkRepository.getCityById(city.id)
        val cityItem =
            CityEntity(city.id, city.name, city.state, city.country, city.coord.lat, city.coord.lon)

        return if (cityByID != null) {
            bookMarkRepository.deleteCity(cityItem)
            0
        } else {
            bookMarkRepository.insertCity(cityItem)
        }
    }
}