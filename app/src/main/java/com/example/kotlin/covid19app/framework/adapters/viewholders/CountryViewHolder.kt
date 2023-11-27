package com.example.kotlin.covid19app.framework.adapters.viewholders

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.covid19app.data.network.model.Country
import com.example.kotlin.covid19app.databinding.ItemCountryBinding
import com.example.kotlin.covid19app.framework.views.DetailActivity

/**
 * ViewHolder para la vista de elementos de país en el RecyclerView.
 */
class CountryViewHolder(private val binding: ItemCountryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    /**
     * Enlaza los datos del país al ViewHolder.
     *
     * @param item Objeto [Country] que contiene la información del país.
     * @param context Contexto de la aplicación.
     */
    @SuppressLint("SetTextI18n")
    fun bind(item: Country, context: Context) {
        binding.TVName.text = "${item.country}: ${item.region}"
        binding.TVCases.text = "CT: ${item.cases.total.toString()}"
        binding.TVNew.text = "CN: ${item.cases.new.toString()}"

        itemView.setOnClickListener { deployDetail(item) }
    }

    /**
     * Abre la actividad de detalles para el país seleccionado.
     *
     * @param item Objeto [Country] que representa el país seleccionado.
     */
    private fun deployDetail(item: Country) {
        val intent = Intent(binding.root.context, DetailActivity::class.java)
        intent.putExtra("selectedCountry", item.country)
        intent.putExtra("region", item.region)
        binding.root.context.startActivity(intent)
    }
}
