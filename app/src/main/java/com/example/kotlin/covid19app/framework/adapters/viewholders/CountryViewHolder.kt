package com.example.kotlin.covid19app.framework.adapters.viewholders

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.covid19app.data.network.model.Country
import com.example.kotlin.covid19app.databinding.ItemCountryBinding


class CountryViewHolder(private val binding: ItemCountryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: Country, context: Context) {
        binding.TVName.text = "${item.country}: ${item.region}"
        binding.TVCases.text = "CT: ${item.cases.total.toString()}"
        binding.TVNew.text = "CN: ${item.cases.new.toString()}"

    }
}