package com.example.templateapplication.toast

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.example.templateapplication.R

fun displayComingSoon(context : Context, feature : String){
    var message = feature + " Coming Soon"
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun displayResult (context : Context, isSuccess : Boolean = true, message : String = ""){
    var view = LayoutInflater.from(context)
        .inflate(R.layout.toast_result, null, false)
    view.findViewById<TextView>(R.id.body).setText(message)
    if(!isSuccess){
        view.background = AppCompatResources.getDrawable(context, R.drawable.failure_rounded)
        view.findViewById<ImageView>(R.id.resultIcon).background = AppCompatResources.getDrawable(context, R.drawable.baseline_clear_24)
        view.findViewById<TextView>(R.id.title).text = "Failure"
    }


    var toast = Toast(context)
    toast.view = view
    toast.duration = Toast.LENGTH_LONG
    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100)
    toast.show()
}