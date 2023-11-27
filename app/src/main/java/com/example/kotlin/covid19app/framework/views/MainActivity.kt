package com.example.kotlin.covid19app.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.covid19app.data.network.model.Country
import com.example.kotlin.covid19app.databinding.ActivityMainBinding
import com.example.kotlin.covid19app.framework.adapters.CountryAdapter
import com.example.kotlin.covid19app.framework.viewmodels.MainViewModel

/**
 * Actividad principal que muestra la lista de países y permite filtrarlos.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter: CountryAdapter = CountryAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa la vinculación de datos
        initializeBinding()

        // Inicializa los observadores para los cambios en los datos
        initializeObservers()

        // Obtiene la lista de países
        viewModel.getCountryList()

        // Inicializa los listeners de la interfaz de usuario
        initializeListeners()
    }

    /**
     * Inicializa la vinculación de datos utilizando el archivo de diseño "ActivityMainBinding".
     */
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * Inicializa los observadores para observar los cambios en los datos del ViewModel.
     */
    private fun initializeObservers() {
        viewModel.countryObjectLiveData.observe(this) { countryObject ->
            setUpRecyclerView(countryObject)
        }
    }

    /**
     * Configura el RecyclerView con la lista de países.
     */
    private fun setUpRecyclerView(dataForList: ArrayList<Country>) {
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

    /**
     * Inicializa los listeners de la interfaz de usuario.
     */
    private fun initializeListeners() {
        binding.ETFilter.addTextChangedListener {
            if (!it.isNullOrEmpty()) {
                viewModel.updateCountryList(it.toString())
            } else {
                viewModel.getCountryList()
            }
        }
    }
}
