package com.sebastianrpo.tallerdeldulce.ui.carrito

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarritoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Acá irá la sección del carrito"
    }
    val text: LiveData<String> = _text
}