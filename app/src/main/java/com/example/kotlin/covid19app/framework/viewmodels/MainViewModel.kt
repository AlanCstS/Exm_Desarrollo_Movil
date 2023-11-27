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

class MainViewModel : ViewModel() {

    val countryObjectLiveData = MutableLiveData<ArrayList<Country>>()
    private val countryListRequirement = CountryListRequirement()
    private var result: CountryObject? = null

    private val _searchResults = MutableLiveData<List<Country>>()
    //val searchResults: LiveData<List<Country>> get() = _searchResults

    fun getCountryList() {
        viewModelScope.launch(Dispatchers.IO) {
            result =
                countryListRequirement(Constants.API_DATE, Constants.API_KEY)
            Log.d("Salida", result?.count().toString())
            CoroutineScope(Dispatchers.Main).launch {
                countryObjectLiveData.postValue(result!!)
            }
        }
    }

    fun updateCountryList(filter: String) {
        if (filter.isNotEmpty()) {
            val filteredCountries = (result?.filter { country -> country.country.lowercase().contains(filter.lowercase()) }) as ArrayList<Country>
            countryObjectLiveData.postValue(filteredCountries)
        }
    }

}