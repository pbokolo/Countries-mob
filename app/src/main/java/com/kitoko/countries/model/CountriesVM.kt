package com.kitoko.countries.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitoko.countries.network.CountriesApi
import kotlinx.coroutines.launch

class CountriesVM: ViewModel() {
    private val _list = MutableLiveData<List<Country>>()
    private val _status = MutableLiveData<String>()
    val list get() = _list
    val status get() = _status

    init {
        getCountries()
    }

    private fun getCountries(){

        viewModelScope.launch{
            try {
//                _list.value = CountriesApi.retrofitService.getAll()
                val res = CountriesApi.retrofitService.getAll()
                _status.value = res
            }catch (e: Exception){
                _status.value = "Error: ${e.message}"
                e.printStackTrace()

            }
        }

    }
}