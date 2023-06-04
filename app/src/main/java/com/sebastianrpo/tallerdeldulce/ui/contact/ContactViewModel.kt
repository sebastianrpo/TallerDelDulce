package com.sebastianrpo.tallerdeldulce.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Acá irá la página de contacto"
    }
    val text: LiveData<String> = _text
}