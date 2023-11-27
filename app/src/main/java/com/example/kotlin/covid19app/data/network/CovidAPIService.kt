package com.example.kotlin.covid19app.data.network

import com.example.kotlin.covid19app.data.network.model.CountryObject
import com.example.kotlin.covid19app.data.network.model.DetailObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Interfaz que define las operaciones de la API de Covid.
 */
interface CovidAPIService {

    /**
     * Obtiene la lista de países para una fecha específica.
     *
     * @param date La fecha para la cual se desea obtener la lista de países.
     * @param xApiKey La clave de autenticación para acceder a la API.
     * @return Un objeto [CountryObject] que contiene la lista de países.
     */
    @GET("covid19")
    suspend fun getCountryList(
        @Query("date") date: String,
        @Header("X-Api-Key") xApiKey: String
    ): CountryObject

    /**
     * Obtiene la lista de detalles para un país específico.
     *
     * @param name El nombre del país para el cual se desea obtener los detalles.
     * @param xApiKey La clave de autenticación para acceder a la API.
     * @return Un objeto [DetailObject] que contiene la lista de detalles.
     */
    @GET("covid19")
    suspend fun getDetailList(
        @Query("name") name: String,
        @Header("X-Api-Key") xApiKey: String
    ): DetailObject
}
