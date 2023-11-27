package com.example.kotlin.covid19app.data.network.model

/**
 * Representa los casos de una entidad en un período de tiempo específico.
 *
 * @property new Nuevos casos reportados en el período.
 * @property total Total acumulado de casos hasta la fecha.
 */
data class Cases(
    val new: Int,
    val total: Int
)
