package com.example.kotlin.covid19app.data.network

import com.example.kotlin.covid19app.data.network.model.CountryObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.Date

interface CovidAPIService {

    // https://api.api-ninjas.com/v1/covid19/?date=2023-02-11
    @GET ("covid19")
    suspend fun getCountryList(
        @Query("date") date:String,
        @Header("X-Api-Key") xApiKey : String
    ): CountryObject

}