package com.example.kotlin.covid19app.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.covid19app.data.network.model.DetailItem
import com.example.kotlin.covid19app.databinding.ActivityDetailBinding
import com.example.kotlin.covid19app.framework.viewmodels.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeComponents()
        // viewModel.getCountryDetail(intent.getStringExtra("selectedCountry"))
    }

    private fun initializeBinding() {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeComponents() {
        val selectedCountry = intent.getStringExtra("selectedCountry")
        val region = intent.getStringExtra("region")
        binding.TVCountry.text = "${selectedCountry}: ${region}"

        // Depliegue crudo de datos
        binding.TVCases.text = DetailItem.sampleCountryData.cases.toString()

    }

}
