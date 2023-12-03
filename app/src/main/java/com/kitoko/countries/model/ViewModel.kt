package com.kitoko.countries.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    private val _list = MutableLiveData<List<String>>()
    private val _status = MutableLiveData<String>()
    val list get() = _list
    val status get() = _status

    init {
        getCountries()
    }

    private fun getCountries(){
        Log.v("Test","Getting data")
    }

}