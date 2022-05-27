package com.example.openweatherapp.presentation.ui.weather

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.data.model.WeatherResponse
import com.example.openweatherapp.data.util.Resource
import com.example.openweatherapp.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val weatherReportLiveData = MutableLiveData<Resource<WeatherResponse>>()
    val weatherReport: LiveData<Resource<WeatherResponse>> = weatherReportLiveData

    private val loadingLiveData = MutableLiveData<Int>()
    val loading: LiveData<Int> = loadingLiveData

    fun getWeatherReport(id: Long, apikey: String) {
        loadingLiveData.postValue(View.VISIBLE)
        viewModelScope.launch {
            val report = weatherUseCase(id, apikey)
            loadingLiveData.postValue(View.GONE)
            weatherReportLiveData.postValue(report)
        }
    }
}