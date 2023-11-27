package com.example.kotlin.covid19app.framework.adapters.viewholders

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.covid19app.data.network.model.Country
import com.example.kotlin.covid19app.databinding.ItemCountryBinding
import com.example.kotlin.covid19app.framework.views.DetailActivity


class CountryViewHolder(private val binding: ItemCountryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: Country, context: Context) {
        binding.TVName.text = "${item.country}: ${item.region}"
        binding.TVCases.text = "CT: ${item.cases.total.toString()}"
        binding.TVNew.text = "CN: ${item.cases.new.toString()}"

        itemView.setOnClickListener {deployDetail(item)}

    }

    private fun deployDetail(item: Country) {
        val intent = Intent(binding.root.context, DetailActivity::class.java)
        intent.putExtra("selectedCountry", item.country)
        intent.putExtra("region", item.region)
        binding.root.context.startActivity(intent)
    }
}