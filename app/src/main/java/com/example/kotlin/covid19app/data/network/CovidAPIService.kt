package com.example.kotlin.covid19app.data.network

import com.example.kotlin.covid19app.data.network.model.CountryObject
import com.example.kotlin.covid19app.data.network.model.DetailObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CovidAPIService {

    // https://api.api-ninjas.com/v1/covid19/?date=2023-02-11
    @GET ("covid19")
    suspend fun getCountryList(
        @Query("date") date:String,
        @Header("X-Api-Key") xApiKey : String
    ): CountryObject

    // https://api.api-ninjas.com/v1/covid19/?country=Mexico
    @GET ("covid19")
    suspend fun getDetailList(
        @Query("name") name:String,
        @Header("X-Api-Key") xApiKey : String
    ): DetailObject


}