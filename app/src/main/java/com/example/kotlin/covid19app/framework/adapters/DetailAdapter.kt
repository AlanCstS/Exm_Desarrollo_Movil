package com.example.kotlin.covid19app.framework.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.covid19app.data.network.model.Cases
import com.example.kotlin.covid19app.databinding.ActivityDetailBinding
import com.example.kotlin.covid19app.framework.adapters.viewholders.DetailViewHolder

class DetailAdapter: RecyclerView.Adapter<DetailViewHolder>() {

    var data: ArrayList<Cases> = ArrayList()
    private lateinit var context: Context

    @SuppressLint("NotConstructor")
    fun CountryAdapter(basicData: ArrayList<Cases>, context:Context) {
        this.data = basicData
        this.context = context
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding = ActivityDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DetailViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}