package com.example.openweatherapp.domain.data

import com.example.openweatherapp.data.db.CityEntity

object FakeDataUtil {

    fun getFakeBookMarkedCities(): MutableList<CityEntity> {
        val citiesList: MutableList<CityEntity> = arrayListOf()
        val city1 = CityEntity(
            cityId = 833,
            cityName = "Ḩeşār-e Sefīd",
            state = "",
            country = "IR",
            lat = 34.330502,
            lon = 47.159401
        )
        val city2 = CityEntity(
            cityId = 18007,
            cityName = "Gollar",
            state = "",
            country = "IR",
            lat = 46.25,
            lon = 37.383331
        )
        citiesList.add(city1)
        citiesList.add(city2)
        return citiesList
    }

    fun getCity(): CityEntity {
        return CityEntity(
            cityId = 833,
            cityName = "Ḩeşār-e Sefīd",
            state = "",
            country = "IR",
            lat = 34.330502,
            lon = 47.159401
        )
    }
}