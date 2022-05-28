package com.example.openweatherapp.presentation.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.openweatherapp.data.util.Constants.API_KEY
import com.example.openweatherapp.data.util.Resource
import com.example.openweatherapp.databinding.FragmentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private val viewModel: WeatherViewModel by viewModels()
    private val args by navArgs<WeatherFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        val id = args.currentItem.id
        viewModel.getWeatherReport(id, API_KEY)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.weatherReport.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Success -> {
                    binding.constraintMain.visibility = View.VISIBLE
                    binding.tvErrorMessage.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE
                    val report = result.data
                    if (report != null) {
                        binding.model = report
                    }
                }
                is Resource.Error -> {
                    binding.constraintMain.visibility = View.GONE
                    binding.progressBar.visibility = View.GONE
                    binding.tvErrorMessage.visibility = View.VISIBLE
                }
            }
        }
    }

}