package com.example.kotlin.covid19app.framework.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.covid19app.data.network.model.Country
import com.example.kotlin.covid19app.databinding.ItemCountryBinding
import com.example.kotlin.covid19app.framework.adapters.viewholders.CountryViewHolder

class CountryAdapter: RecyclerView.Adapter<CountryViewHolder>() {

    var data: ArrayList<Country> = ArrayList()
    private lateinit var context: Context

    @SuppressLint("NotConstructor")
    fun CountryAdapter(basicData: ArrayList<Country>, context:Context) {
        this.data = basicData
        this.context = context
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}