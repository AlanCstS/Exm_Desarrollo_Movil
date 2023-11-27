package com.example.kotlin.covid19app.data.network

import com.example.kotlin.covid19app.data.network.model.CountryObject
import com.example.kotlin.covid19app.data.network.model.DetailObject

class CovidApiClient {
    private lateinit var api: CovidAPIService

    suspend fun getCountryList(date:String, key: String): CountryObject? {
        api = NetworkModuleDI()
        return try {
            api.getCountryList(date, key)
        } catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }

    }suspend fun getDetailList(name:String, key: String): DetailObject? {
        api = NetworkModuleDI()
        return try {
            api.getDetailList(name, key)
        } catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}