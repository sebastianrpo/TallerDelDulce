package com.sebastianrpo.tallerdeldulce.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel : ViewModel() {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _registerResult = MutableLiveData<RegisterResult>()
    val registerResult: LiveData<RegisterResult> = _registerResult

    fun register(email: String, password: String, confirmPassword: String) {
        if (password.length < 7) {
            _registerResult.value = RegisterResult(success = false, error = "La contraseña debe tener al menos 7 caracteres")
            return
        }

        if (password != confirmPassword) {
            _registerResult.value = RegisterResult(success = false, error = "Las contraseñas no coinciden")
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _registerResult.value = RegisterResult(success = true)
                } else {
                    val error = task.exception?.message ?: "Error desconocido"
                    _registerResult.value = RegisterResult(success = false, error = error)
                }
            }
    }
}

data class RegisterResult(val success: Boolean, val error: String = "")
