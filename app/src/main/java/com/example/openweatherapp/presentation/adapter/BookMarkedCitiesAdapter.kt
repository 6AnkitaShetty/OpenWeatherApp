package com.example.openweatherapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapp.data.model.City
import com.example.openweatherapp.databinding.ItemBookmarkedCityLayoutBinding

class BookMarkedCitiesAdapter :
    RecyclerView.Adapter<BookMarkedCitiesAdapter.BookMarkedCitiesAdapterViewHolder>() {

    inner class BookMarkedCitiesAdapterViewHolder(private val binding: ItemBookmarkedCityLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: City) {
            binding.model = entity
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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookMarkedCitiesAdapterViewHolder {
        val binding =
            ItemBookmarkedCityLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return BookMarkedCitiesAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: BookMarkedCitiesAdapterViewHolder, position: Int) {
        val city = differ.currentList[position]
        if (city != null) {
            holder.bind(city)
        }
    }
}