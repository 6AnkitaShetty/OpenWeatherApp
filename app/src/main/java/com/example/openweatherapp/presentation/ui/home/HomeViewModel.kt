package com.example.openweatherapp.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.data.db.CityEntity
import com.example.openweatherapp.data.util.Resource
import com.example.openweatherapp.domain.usecase.BookMarkedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bookMarkedUseCase: BookMarkedUseCase
) : ViewModel() {

    private val bookMarkedLocationsLiveData = MutableLiveData<Resource<List<CityEntity>>>()
    val bookMarkedLocations: LiveData<Resource<List<CityEntity>>> = bookMarkedLocationsLiveData

    fun getBookMarkedCities() {
        viewModelScope.launch {
            val cities = bookMarkedUseCase.getBokMarkedCitiesUseCase.invoke()
            bookMarkedLocationsLiveData.postValue(Resource.Success(cities))
        }
    }

    fun deleteCity(cityEntity: CityEntity) {
        viewModelScope.launch {
            bookMarkedUseCase.deleteCityUseCase.invoke(cityEntity)
        }
    }

    fun insertCity(cityEntity: CityEntity) {
        viewModelScope.launch {
            bookMarkedUseCase.insertCityUseCase.invoke(cityEntity)
        }
    }

}