package com.sebastianrpo.tallerdeldulce.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BebidasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Acá irá la página de bebidas"
    }
    val text: LiveData<String> = _text
}