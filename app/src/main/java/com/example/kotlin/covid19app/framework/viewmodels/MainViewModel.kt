package com.example.kotlin.covid19app.framework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.covid19app.data.network.model.Country
import com.example.kotlin.covid19app.data.network.model.CountryObject
import com.example.kotlin.covid19app.domain.CountryListRequirement
import com.example.kotlin.covid19app.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel principal que maneja la lógica de la pantalla principal.
 */
class MainViewModel : ViewModel() {

    // LiveData para contener la lista de países
    val countryObjectLiveData = MutableLiveData<ArrayList<Country>>()

    // Instancia del requisito de lista de países
    private val countryListRequirement = CountryListRequirement()

    // Objeto de resultado de la lista de países
    private var result: CountryObject? = null

    /**
     * Obtiene la lista de países y actualiza el LiveData.
     */
    fun getCountryList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Obtiene la lista de países
                result =
                    countryListRequirement(Constants.API_DATE, Constants.API_KEY)
                Log.d("Output", result?.count().toString())

                // Actualiza el LiveData en el hilo principal
                CoroutineScope(Dispatchers.Main).launch {
                    countryObjectLiveData.postValue(result!!)
                }
            } catch (e: Exception) {
                // Manejo de errores, si es necesario
                Log.e("MainViewModel", "Error: ${e.message}")
            }
        }
    }

    /**
     * Filtra la lista de países según el texto de búsqueda y actualiza el LiveData.
     *
     * @param filter Texto de búsqueda.
     */
    fun updateCountryList(filter: String) {
        if (filter.isNotEmpty()) {
            // Filtra los países según el texto de búsqueda
            val filteredCountries =
                (result?.filter { country -> country.country.lowercase().contains(filter.lowercase()) }) as ArrayList<Country>
            countryObjectLiveData.postValue(filteredCountries)
        }
    }
}
