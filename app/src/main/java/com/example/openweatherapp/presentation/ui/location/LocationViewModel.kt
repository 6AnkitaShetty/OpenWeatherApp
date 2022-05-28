package com.example.openweatherapp.presentation.ui.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.domain.usecase.BookMarkedUseCase
import com.example.openweatherapp.domain.usecase.GetCitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val getCitiesUseCase: GetCitiesUseCase,
    private val bookMarkedUseCase: BookMarkedUseCase
) : ViewModel() {

    private val bookMarkedLocationLiveData = MutableLiveData<Long?>()
    val bookMarkedLocation: LiveData<Long?> = bookMarkedLocationLiveData

    private val citiesLiveData = MutableLiveData<List<City>?>()
    val cities: LiveData<List<City>?> = citiesLiveData

    fun insertCity(city: City) {
        viewModelScope.launch {
            val id = bookMarkedUseCase.bookMarkCityUseCase.invoke(city)
            bookMarkedLocationLiveData.postValue(id)
        }
    }

    fun getCities() {
        viewModelScope.launch {
            val cities = getCitiesUseCase()
            citiesLiveData.postValue(cities)
        }
    }
}