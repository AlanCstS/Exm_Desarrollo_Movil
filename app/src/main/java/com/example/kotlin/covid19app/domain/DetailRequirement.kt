package com.example.kotlin.covid19app.domain

import com.example.kotlin.covid19app.data.CountryRepository
import com.example.kotlin.covid19app.data.network.model.DetailObject

/**
 * Caso de uso que define los requisitos para obtener detalles específicos.
 */
class DetailRequirement {

    private val repository = CountryRepository()

    /**
     * Invoca el repositorio para obtener detalles específicos.
     *
     * @param name Nombre del país para el cual se desean obtener detalles.
     * @param key Clave de la API.
     * @return Objeto [DetailObject] que contiene los detalles o null en caso de error.
     */
    suspend operator fun invoke(name: String, key: String): DetailObject? = repository.getDetailList(name, key)
}
