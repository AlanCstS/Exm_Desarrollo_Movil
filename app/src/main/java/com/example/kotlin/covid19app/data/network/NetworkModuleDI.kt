package com.example.kotlin.covid19app.data.network

import com.example.kotlin.covid19app.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Módulo de red que proporciona una instancia de [CovidAPIService] usando Retrofit.
 */
object NetworkModuleDI {

    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()
    private val okHttpClient: OkHttpClient = OkHttpClient()

    /**
     * Obtiene una instancia de [CovidAPIService].
     *
     * @return Una instancia de [CovidAPIService].
     */
    operator fun invoke(): CovidAPIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(CovidAPIService::class.java)
    }
}
