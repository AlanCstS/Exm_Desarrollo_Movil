package com.example.kotlin.covid19app.data

import com.example.kotlin.covid19app.data.network.model.CountryObject
import com.example.kotlin.covid19app.data.network.CovidApiClient
import com.example.kotlin.covid19app.data.network.model.DetailObject

/**
 * Repositorio que actúa como fuente de datos para la obtención de listas de países y detalles de casos.
 */
class CountryRepository() {
    private val apiCountry = CovidApiClient()

    /**
     * Obtiene la lista de países.
     *
     * @param date Fecha para la cual se desea obtener la lista.
     * @param key Clave de la API.
     * @return Objeto [CountryObject] que contiene la lista de países o null en caso de error.
     */
    suspend fun getCountryList(date: String, key: String): CountryObject? = apiCountry.getCountryList(date, key)

    /**
     * Obtiene la lista de detalles de casos para un país específico.
     *
     * @param name Nombre del país para el cual se desea obtener los detalles de casos.
     * @param key Clave de la API.
     * @return Objeto [DetailObject] que contiene la lista de detalles de casos o null en caso de error.
     */
    suspend fun getDetailList(name: String, key: String): DetailObject? = apiCountry.getDetailList(name, key)
}
