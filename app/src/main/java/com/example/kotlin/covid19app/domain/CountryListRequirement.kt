package com.example.kotlin.covid19app.domain

import com.example.kotlin.covid19app.data.CountryRepository
import com.example.kotlin.covid19app.data.network.model.CountryObject

class CountryListRequirement {

    private val repository = CountryRepository()

    suspend operator fun invoke(
        date:String,
        key: String
    ): CountryObject? = repository.getCountryList(date, key)

}