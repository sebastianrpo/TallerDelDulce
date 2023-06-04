package com.sebastianrpo.tallerdeldulce.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sebastianrpo.tallerdeldulce.R
import com.sebastianrpo.tallerdeldulce.ui.login.LoginActivity
import com.sebastianrpo.tallerdeldulce.ui.mainactivity.MainActivity
import com.sebastianrpo.tallerdeldulce.ui.register.RegisterActivity
import java.util.Timer
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timer = Timer()
        timer.schedule(
            timerTask {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            },
            2000
        )
    }
}