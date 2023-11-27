package com.example.kotlin.covid19app.data.network.model

/**
 * Representa la información detallada de un país en relación con los casos de COVID-19.
 *
 * @property cases Información detallada de casos en el país.
 * @property country Nombre del país.
 * @property region Nombre de la región (puede ser una cadena vacía si no hay región específica).
 */
data class Country(
    val cases: Cases,
    val country: String,
    val region: String
)
