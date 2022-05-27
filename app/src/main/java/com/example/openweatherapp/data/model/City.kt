package com.example.openweatherapp.data.model

data class City(
    val id: Long,
    val name: String,
    val state: String,
    val country: String,
    val coord: Coord
)