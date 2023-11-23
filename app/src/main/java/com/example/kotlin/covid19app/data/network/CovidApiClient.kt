package com.example.kotlin.covid19app.data.network

class CovidApiClient {
    private lateinit var api: CovidAPIService

    suspend fun getCountryList(date:String, key: String): com.example.kotlin.covid19app.data.network.model.CountryObject? {
        api = NetworkModuleDI()
        return try {
            api.getCountryList(date, key)
        } catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}