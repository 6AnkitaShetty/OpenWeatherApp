package com.example.openweatherapp.presentation.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.databinding.FragmentLocationBinding
import com.example.openweatherapp.presentation.adapter.LocationsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment : Fragment() {

    private lateinit var binding: FragmentLocationBinding
    private val viewModel: LocationViewModel by viewModels()

    private val adapter = LocationsAdapter()
    private var cityList = emptyList<City>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        binding.toolbarHome.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setUpObservers()
    }

    private fun setUpObservers() {
        binding.searchLocations.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    viewModel.getCities()
                    if (cityList.isNotEmpty()) {
                        val list =
                            cityList.filter {
                                it.name.lowercase().contains(newText.toString().lowercase())
                            }
                        adapter.differ.submitList(list)
                    }
                    return false
                }
            }
        )

        viewModel.bookMarkedLocation.observe(viewLifecycleOwner) {
            activity?.onBackPressed()
        }

        viewModel.cities.observe(viewLifecycleOwner) {
            if (it != null) {
                cityList = it
            }
        }
    }

    private fun setAdapter() {
        binding.adapter = adapter
        adapter.setOnItemClickListener { city ->
            viewModel.insertCity(city)
        }
    }

}