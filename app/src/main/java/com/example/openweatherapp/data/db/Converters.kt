package com.example.openweatherapp.data.db

import androidx.room.TypeConverter
import com.example.openweatherapp.data.model.Coord
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun coordToString(coord: Coord): String = Gson().toJson(coord)

    @TypeConverter
    fun stringToCoord(string: String): Coord = Gson().fromJson(string, Coord::class.java)

}