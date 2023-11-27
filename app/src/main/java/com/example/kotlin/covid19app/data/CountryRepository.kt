package com.example.kotlin.covid19app.data

import com.example.kotlin.covid19app.data.network.model.CountryObject
import com.example.kotlin.covid19app.data.network.CovidApiClient
import com.example.kotlin.covid19app.data.network.model.DetailObject

class CountryRepository() {
    private val apiCountry = CovidApiClient()
    suspend fun getCountryList(date:String, key: String): CountryObject? = apiCountry.getCountryList(date, key)
    suspend fun getDetailList(name:String, key: String): DetailObject? = apiCountry.getDetailList(name, key)

}