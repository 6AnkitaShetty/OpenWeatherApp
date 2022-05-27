package com.example.openweatherapp.data.util

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.openweatherapp.R
import com.example.openweatherapp.data.db.CityEntity
import com.example.openweatherapp.data.model.WeatherResponse
import com.example.openweatherapp.data.util.Util.unixTimestampToDateTimeString
import com.example.openweatherapp.data.util.Util.unixTimestampToTimeString
import com.example.openweatherapp.presentation.ui.home.HomeFragmentDirections
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("temperatureDescription")
fun setTemperatureDescription(textView: TextView, model: WeatherResponse?) {
    model?.let {
        val maxTemperatureInCelsius = Util.kelvinToCelsius(model.main.temp_max)
        val minTemperatureInCelsius = Util.kelvinToCelsius(model.main.temp_min)
        val realFeelTemperatureInCelsius = Util.kelvinToCelsius(model.main.feels_like)
        textView.text =
            textView.context.getString(
                R.string.temp_celsius,
                maxTemperatureInCelsius.toInt(),
                minTemperatureInCelsius.toInt(),
                realFeelTemperatureInCelsius.toInt()
            )
    }
}

@BindingAdapter("tempToDegree")
fun setTemperatureToDegree(textView: TextView, tempInKelvin: Double) {
    val temperatureInCelsius = Util.kelvinToCelsius(tempInKelvin)
    textView.text =
        textView.context.getString(R.string.temp_degree, temperatureInCelsius.toInt())
}

@BindingAdapter("description")
fun setDescriptionText(textView: TextView, model: WeatherResponse?) {
    if (model?.weather != null && model.weather.isNotEmpty()) {
        textView.text = model.weather.first().description
    }
}

@BindingAdapter("timeText")
fun setTimeText(textView: TextView, time: Int) {
    textView.text =time.unixTimestampToTimeString()
}

@BindingAdapter("dateTimeText")
fun setDateTimeText(textView: TextView, time: Int) {
    textView.text =time.unixTimestampToDateTimeString()
}

@BindingAdapter("displayImage")
fun ImageView.setDisplayImage(response: WeatherResponse?) {
    if (response?.weather != null && response.weather.isNotEmpty()) {
        val imageUrl = "https://openweathermap.org/img/w/${response.weather.first().icon}.png"
        Glide.with(this)
            .load(imageUrl)
            .placeholder(android.R.drawable.progress_indeterminate_horizontal)
            .error(android.R.drawable.stat_notify_error)
            .into(this)
    }
}

@BindingAdapter("cityAndCountry")
fun setCityAndCountry(textView: TextView,response: WeatherResponse?) {
    response?.let {
        textView.text =textView.context.getString(R.string.city_country_name, it.name,it.sys.country)
    }
}

@BindingAdapter("location")
fun setLocation(textView: TextView,currentEntity: CityEntity) {
    textView.text =textView.context.getString(R.string.city_country_name, currentEntity.cityName,currentEntity.country)

}

@BindingAdapter("android:navigateToLocationFragment")
fun navigateToLocationFragment(view: FloatingActionButton, navigate: Boolean){
    view.setOnClickListener {
        if(navigate){
            view.findNavController().navigate(R.id.action_HomeFragment_to_LocationFragment)
        }
    }
}

@BindingAdapter("android:sendDataToWeatherFragment")
fun sendDataToWeatherFragment(view: ConstraintLayout, currentEntity: CityEntity) {
    view.setOnClickListener {
        val action = HomeFragmentDirections.actionHomeFragmentToWeatherFragment(currentEntity)
        view.findNavController().navigate(action)
    }
}

