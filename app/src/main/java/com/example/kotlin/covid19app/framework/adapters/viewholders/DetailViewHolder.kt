package com.example.kotlin.covid19app.framework.adapters.viewholders

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.covid19app.data.network.model.Cases
import com.example.kotlin.covid19app.databinding.ActivityDetailBinding
import com.example.kotlin.covid19app.framework.views.DetailActivity


class DetailViewHolder(private val binding: ActivityDetailBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: Cases, context: Context) {

    }

}