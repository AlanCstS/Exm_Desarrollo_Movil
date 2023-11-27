package com.example.kotlin.covid19app.domain

import com.example.kotlin.covid19app.data.CountryRepository
import com.example.kotlin.covid19app.data.network.model.DetailObject

class DetailRequirement {

    private val repository = CountryRepository()

    suspend operator fun invoke(
        name: String,
        key: String
    ): DetailObject? = repository.getDetailList(name, key)

}