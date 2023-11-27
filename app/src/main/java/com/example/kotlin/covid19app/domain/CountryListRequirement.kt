package com.example.kotlin.covid19app.domain

import com.example.kotlin.covid19app.data.CountryRepository
import com.example.kotlin.covid19app.data.network.model.CountryObject

/**
 * Caso de uso que define los requisitos para obtener la lista de países.
 */
class CountryListRequirement {

    private val repository = CountryRepository()

    /**
     * Invoca el repositorio para obtener la lista de países.
     *
     * @param date Fecha para la cual se desea obtener la lista.
     * @param key Clave de la API.
     * @return Objeto [CountryObject] que contiene la lista de países o null en caso de error.
     */
    suspend operator fun invoke(date: String, key: String): CountryObject? = repository.getCountryList(date, key)
}
