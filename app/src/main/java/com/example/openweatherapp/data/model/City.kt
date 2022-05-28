package com.example.openweatherapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "City")
data class City(
    @PrimaryKey
    val id: Long,
    val name: String,
    val state: String,
    val country: String,
    val coord: Coord
): Serializable