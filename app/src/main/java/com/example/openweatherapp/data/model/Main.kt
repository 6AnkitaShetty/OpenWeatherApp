package com.example.openweatherapp.data.model

data class Main(
    val temp: Double,
    val pressure: Int,
    val humidity: Int,
    val temp_max: Double,
    val temp_min: Double,
    val feels_like: Double,
)