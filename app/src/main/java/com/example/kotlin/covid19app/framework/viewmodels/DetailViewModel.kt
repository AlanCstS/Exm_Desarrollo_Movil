package com.example.kotlin.covid19app.framework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.covid19app.data.network.model.DetailObject
import com.example.kotlin.covid19app.domain.DetailRequirement
import com.example.kotlin.covid19app.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DetailViewModel : ViewModel() {

    private val detailObjectLiveData = MutableLiveData<DetailObject>()
    private val detailRequirement = DetailRequirement()

    fun getCountryDetail(countryName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result: DetailObject? =
                detailRequirement(countryName, Constants.API_KEY)
            Log.d("Salida Detalle", result?.count().toString())
            CoroutineScope(Dispatchers.Main).launch {
                detailObjectLiveData.postValue(result!!)
            }
        }
    }
}