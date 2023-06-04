package com.sebastianrpo.tallerdeldulce.ui.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.sebastianrpo.tallerdeldulce.R
import com.sebastianrpo.tallerdeldulce.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isUserLoggedIn = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_notices, R.id.navigation_contact, R.id.navigation_carrito
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val firebaseAuth = FirebaseAuth.getInstance()
        isUserLoggedIn = firebaseAuth.currentUser != null


    }
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            // Si no hay fragmentos en la pila, cierra la aplicación
            finish()
        } else {
            super.onBackPressed()
        }
    }

}