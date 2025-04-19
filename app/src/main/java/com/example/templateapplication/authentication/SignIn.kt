package com.example.templateapplication.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.templateapplication.MainActivity
import com.example.templateapplication.R

class SignIn : AppCompatActivity(){
    //views
    private lateinit var btnSignin : Button

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        initViews()
    }
    private fun initViews(){
        btnSignin = findViewById<Button>(R.id.btnSignin)

        btnSignin.setOnClickListener{
            authenticate()
        }
    }

    private fun authenticate(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}