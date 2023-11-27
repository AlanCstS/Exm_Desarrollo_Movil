package com.example.kotlin.covid19app.data.network

import com.example.kotlin.covid19app.data.network.model.CountryObject
import com.example.kotlin.covid19app.data.network.model.DetailObject

/**
 * Clase que actúa como cliente para realizar solicitudes a la API de Covid.
 * Utiliza [CovidAPIService] para interactuar con la API y obtener datos relacionados con países y detalles.
 */
class CovidApiClient {

    private lateinit var api: CovidAPIService

    /**
     * Obtiene la lista de países para una fecha específica.
     *
     * @param date La fecha para la cual se desea obtener la lista de países.
     * @param key La clave de autenticación para acceder a la API.
     * @return Un objeto [CountryObject] que contiene la lista de países o null si hay un error.
     */
    suspend fun getCountryList(date: String, key: String): CountryObject? {
        api = NetworkModuleDI()
        return try {
            api.getCountryList(date, key)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    /**
     * Obtiene la lista de detalles para un país específico.
     *
     * @param name El nombre del país para el cual se desea obtener los detalles.
     * @param key La clave de autenticación para acceder a la API.
     * @return Un objeto [DetailObject] que contiene la lista de detalles o null si hay un error.
     */
    suspend fun getDetailList(name: String, key: String): DetailObject? {
        api = NetworkModuleDI()
        return try {
            api.getDetailList(name, key)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
