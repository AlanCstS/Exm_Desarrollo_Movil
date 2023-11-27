package com.example.kotlin.covid19app.framework.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.covid19app.data.network.model.DetailItem
import com.example.kotlin.covid19app.databinding.ActivityDetailBinding

/**
 * Actividad que muestra los detalles de un país seleccionado.
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa la vinculación de datos
        initializeBinding()

        // Inicializa los componentes de la actividad
        initializeComponents()

    }

    /**
     * Inicializa la vinculación de datos utilizando el archivo de diseño "ActivityDetailBinding".
     */
    private fun initializeBinding() {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * Inicializa los componentes de la actividad.
     */
    private fun initializeComponents() {
        // Obtiene el nombre del país y la región del intent
        val selectedCountry = intent.getStringExtra("selectedCountry")
        val region = intent.getStringExtra("region")

        // Actualiza el texto del TextView con el nombre del país y la región
        binding.TVCountry.text = "${selectedCountry}: ${region}"

        // Despliegue crudo de datos (se debe mejorar con la implementación correcta de ViewModel)
        binding.TVCases.text = DetailItem.sampleCountryData.cases.toString()
    }
}
