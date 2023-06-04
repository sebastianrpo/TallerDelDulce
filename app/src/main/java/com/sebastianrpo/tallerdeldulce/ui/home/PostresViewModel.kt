package com.sebastianrpo.tallerdeldulce.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostresViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Acá irá la página de postres"
    }
    val text: LiveData<String> = _text
}