package com.example.openweatherapp.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.R
import com.example.openweatherapp.data.db.CityEntity
import com.example.openweatherapp.data.util.Resource
import com.example.openweatherapp.databinding.FragmentHomeBinding
import com.example.openweatherapp.presentation.adapter.BookMarkedCitiesAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private var bookMarkedCitiesAdapter: BookMarkedCitiesAdapter = BookMarkedCitiesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        viewModel.getBookMarkedCities()
        setAdapter()
        setUpObservers()
        return binding.root
    }

    private fun setUpObservers() {
        viewModel.bookMarkedLocations.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let {
                        if (it.isEmpty()) {
                            binding.emptyLocationsMessage.visibility = View.VISIBLE
                        } else {
                            binding.emptyLocationsMessage.visibility = View.GONE
                            bookMarkedCitiesAdapter.differ.submitList(it)
                        }
                    }
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), R.string.unknown_error, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun setAdapter() {
        binding.adapter = bookMarkedCitiesAdapter
        swipeToDelete(binding.rvSavedLocations)
    }

    private fun swipeToDelete(recyclerView: RecyclerView) {
        val swipeToDeleteCallback = object : SwipeToDelete() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val deletedItem = bookMarkedCitiesAdapter.differ.currentList[viewHolder.adapterPosition]
                // Delete Item
                viewModel.deleteCity(deletedItem)
                // Restore Deleted Item
                restoreDeletedData(viewHolder.itemView, deletedItem,viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun restoreDeletedData(view: View, deletedEntity: CityEntity, position:Int) {
        val snackBar = Snackbar.make(
            view, "Deleted '${deletedEntity.cityName}'",
            Snackbar.LENGTH_LONG
        )
        snackBar.setAction("Undo") {
            viewModel.insertCity(deletedEntity)
            bookMarkedCitiesAdapter.notifyItemChanged(position)
        }
        snackBar.show()
    }

}