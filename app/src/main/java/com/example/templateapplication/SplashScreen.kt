package com.example.templateapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.templateapplication.authentication.SignIn

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}