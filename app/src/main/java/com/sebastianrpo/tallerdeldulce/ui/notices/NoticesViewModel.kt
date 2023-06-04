package com.sebastianrpo.tallerdeldulce.ui.notices

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoticesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Acá irá la sección de noticias"
    }
    val text: LiveData<String> = _text
}