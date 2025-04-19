package com.example.templateapplication.notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import com.example.templateapplication.Globals
import com.example.templateapplication.R

class MainNotification (private var context : Context) {
    val ntfMng = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    private val reminderChannelId = "Reminder"
    private val reminderName = "Reminder"
    private val reminderDescription = "Reminder Description"

    init{
        createNotificationChannel(reminderName, reminderDescription, NotificationManager.IMPORTANCE_HIGH)
    }

    private fun hasPermission() : Boolean = ActivityCompat.checkSelfPermission( context, Manifest.permission.POST_NOTIFICATIONS ) == PackageManager.PERMISSION_GRANTED

    private fun createNotificationChannel(name : String, description : String, importance : Int){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel( reminderChannelId, name, importance ).apply{ setDescription(description) }

            ntfMng.createNotificationChannel(channel)
        }
    }

    fun sendReminder(title : String, text : String){
        if (!hasPermission()){return}

        val icon = R.drawable.ic_launcher_foreground

        val notification = NotificationCompat.Builder(context, reminderChannelId)
            .setSmallIcon(icon)
            .setContentTitle(title)
            .setContentText(text)
            .setAutoCancel(true)
            .build()

        ntfMng.notify(Globals.notificationCounter, notification)
    }
}