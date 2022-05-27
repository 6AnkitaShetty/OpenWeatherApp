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

    private val bookMarkedLocationIdLiveData = MutableLiveData<Long?>()
    val bookMarkedLocationId: LiveData<Long?> = bookMarkedLocationIdLiveData

    private val citiesListLiveData = MutableLiveData<List<City>?>()
    val citiesList: LiveData<List<City>?> = citiesListLiveData

    fun insertCity(city: City) {
        viewModelScope.launch {
            val id = bookMarkedUseCase.bookMarkCityUseCase.invoke(city)
            bookMarkedLocationIdLiveData.postValue(id)
        }
    }

    fun getCities() {
        viewModelScope.launch {
            val cities = getCitiesUseCase()
            citiesListLiveData.postValue(cities)
        }
    }
}