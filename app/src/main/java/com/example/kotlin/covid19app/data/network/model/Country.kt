package com.example.kotlin.covid19app.data.network.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country") val country: String,
    @SerializedName("region") val region: String,
    @SerializedName("cases") val cases:ArrayList<Int>,
)