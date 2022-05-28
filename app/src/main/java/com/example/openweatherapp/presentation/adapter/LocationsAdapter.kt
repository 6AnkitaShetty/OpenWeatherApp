package com.example.openweatherapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.databinding.ItemCityLayoutBinding

class LocationsAdapter(
    private val citiesList: ArrayList<City>
) : RecyclerView.Adapter<LocationsAdapter.DataViewHolder>() {

    private var onItemClickListener: ((City) -> Unit)? = null

    inner class DataViewHolder(val binding: ItemCityLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: City) {
            binding.model = item
            binding.mainView.setOnClickListener {
                onItemClickListener?.let { it(item) }
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding =
            ItemCityLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = citiesList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val city = citiesList[position]
        holder.bind(city)
        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let {
                    it(city)
                }
            }
        }
    }

    fun setOnItemClickListener(listener: (City) -> Unit) {
        onItemClickListener = listener
    }

    fun addData(list: List<City>) {
        citiesList.clear()
        citiesList.addAll(list)
    }

}