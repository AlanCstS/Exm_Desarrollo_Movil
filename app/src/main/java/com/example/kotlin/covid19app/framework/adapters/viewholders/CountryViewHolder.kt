package com.example.kotlin.covid19app.framework.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.covid19app.data.network.model.Country
import com.example.kotlin.covid19app.databinding.ItemCountryBinding


class CountryViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Country, context: Context){
        binding.TVName.text = item.country
        binding.TVCases.text = item.cases[0].toString() + " casos"
        binding.TVNew.text = item.cases[1].toString() + " nuevos casos"
    }
}