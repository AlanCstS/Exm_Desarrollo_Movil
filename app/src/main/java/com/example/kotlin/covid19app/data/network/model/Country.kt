package com.example.kotlin.covid19app.data.network.model

data class Country(
    val cases: Cases,
    val country: String,
    val region: String
)