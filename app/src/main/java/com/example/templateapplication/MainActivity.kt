package com.example.templateapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.templateapplication.toast.displayResult
import com.example.templateapplication.toolbar.MainToolBar

class MainActivity : AppCompatActivity() {
    // views
    private lateinit var toolbar : MainToolBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        initToolBar()

        displayResult(this, true, "Login Successful")
        displayResult(this, false, "Can't fetch user data")
    }

    private fun initViews(){
        toolbar = findViewById(R.id.toolbar)
    }

    private fun initToolBar(){
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        toolbar.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        return toolbar.onOptionsItemSelected(item)
    }
}