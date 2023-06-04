package com.sebastianrpo.tallerdeldulce.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sebastianrpo.tallerdeldulce.databinding.ActivityLoginBinding
import com.sebastianrpo.tallerdeldulce.ui.mainactivity.MainActivity
import com.sebastianrpo.tallerdeldulce.ui.register.RegisterActivity
import com.sebastianrpo.tallerdeldulce.ui.splash.SplashActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            super.finish()
        }

        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val pass = binding.passwordEditText.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                if (pass.length > 6) {
                    loginViewModel.signIn(email, pass)
                } else {
                    Toast.makeText(
                        this,
                        "La contraseña debe tener al menos 7 caracteres",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this, "No se permiten espacios en blanco", Toast.LENGTH_SHORT).show()
            }
        }

        loginViewModel.loginResult.observe(this, Observer { result ->
            if (result.success) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                super.finish()
            } else {
                Toast.makeText(this, result.error, Toast.LENGTH_SHORT).show()
            }
            super.finish()
        })
    }

    override fun onStart() {
        super.onStart()

        if (loginViewModel.isUserLoggedIn()) {
            // User is already logged in, start MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
