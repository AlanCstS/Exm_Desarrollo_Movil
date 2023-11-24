package com.example.kotlin.covid19app.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.covid19app.data.network.model.Country
import com.example.kotlin.covid19app.databinding.ActivityMainBinding
import com.example.kotlin.covid19app.framework.adapters.CountryAdapter
import com.example.kotlin.covid19app.framework.viewmodels.MainViewModel

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: CountryAdapter = CountryAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getCountryList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){
        viewModel.countryObjectLiveData.observe(this) { countryObject ->
            setUpRecyclerView(countryObject)
        }
    }

    // TODO: Convertir a grid
    private fun setUpRecyclerView(dataForList:ArrayList<Country>){
        binding.RVCovid.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.RVCovid.layoutManager = linearLayoutManager
        adapter.CountryAdapter(dataForList, this)
        binding.RVCovid.adapter = adapter
    }

}