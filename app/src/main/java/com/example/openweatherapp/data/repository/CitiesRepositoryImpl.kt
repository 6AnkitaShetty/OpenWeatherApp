package com.example.openweatherapp.data.repository

import android.content.Context
import android.content.res.AssetManager
import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.repository.CitiesRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.lang.reflect.Type

class CitiesRepositoryImpl(
    private val context: Context
) : CitiesRepository {
    override suspend fun getCities(): List<City>? {
        val jsonString = getAssetJSONFile("city.list.json", context)
        val listType: Type = object : TypeToken<List<City?>?>() {}.type
        return Gson().fromJson(jsonString, listType)
    }

    private fun getAssetJSONFile(filename: String?, context: Context): String? {
        val manager: AssetManager = context.assets
        val file: InputStream? = filename?.let { manager.open(it) }
        val formArray = file?.available()?.let { ByteArray(it) }
        file?.read(formArray)
        file?.close()
        return formArray?.let { String(it) }
    }
}