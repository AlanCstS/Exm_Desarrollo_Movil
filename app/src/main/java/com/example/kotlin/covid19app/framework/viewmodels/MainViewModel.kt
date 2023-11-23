package com.example.kotlin.covid19app.framework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.covid19app.data.CountryRepository
import com.example.kotlin.covid19app.data.network.model.CountryObject
import com.example.kotlin.covid19app.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val countryObjectLiveData = MutableLiveData<CountryObject>()

    fun getCountryList(){
        viewModelScope.launch(Dispatchers.IO) {
            val countryRepository = CountryRepository()
            val result: CountryObject? = countryRepository.getCountryList(Constants.API_DATE, Constants.API_KEY)
            Log.d("Salida", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                countryObjectLiveData.postValue(result!!)
            }
        }
    }
}