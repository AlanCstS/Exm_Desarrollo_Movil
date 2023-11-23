package com.example.kotlin.covid19app.data.network.model

import com.google.gson.annotations.SerializedName

data class CountryObject(
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: ArrayList<Country>,
)

