package com.sebastianrpo.tallerdeldulce.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sebastianrpo.tallerdeldulce.R
import com.sebastianrpo.tallerdeldulce.databinding.ActivitySplashBinding
import com.sebastianrpo.tallerdeldulce.ui.login.LoginActivity
import com.sebastianrpo.tallerdeldulce.ui.mainactivity.MainActivity
import com.sebastianrpo.tallerdeldulce.ui.register.RegisterActivity
import java.util.Timer
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)

        val timer = Timer()
        timer.schedule(timerTask {
            if (Firebase.auth.currentUser != null) {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 2000)
    }
}