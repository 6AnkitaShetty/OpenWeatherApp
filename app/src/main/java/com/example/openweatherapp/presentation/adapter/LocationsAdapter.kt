package com.example.openweatherapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.databinding.ItemCityLayoutBinding

class LocationsAdapter: RecyclerView.Adapter<LocationsAdapter.LocationsAdapterViewHolder>() {

    private var onItemClickListener: ((City) -> Unit)? = null

    inner class LocationsAdapterViewHolder(val binding: ItemCityLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: City) {
            binding.model = item
            binding.mainView.setOnClickListener {
                onItemClickListener?.let { it(item) }
            }
            binding.executePendingBindings()
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldEntity: City, newEntity: City): Boolean {
            return oldEntity.id == newEntity.id
        }

        override fun areContentsTheSame(oldEntity: City, newEntity: City): Boolean {
            return oldEntity == newEntity
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsAdapterViewHolder {
        val binding =
            ItemCityLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return LocationsAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: LocationsAdapterViewHolder, position: Int) {
        val city = differ.currentList[position]
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

}