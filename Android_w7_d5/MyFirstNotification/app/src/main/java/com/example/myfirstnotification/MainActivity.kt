package com.example.myfirstnotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.location.OnNmeaMessageListener
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {

    lateinit var nm: NotificationManager
    lateinit var nc: NotificationChannel
    lateinit var nb: Notification.Builder
    val cId = "mychannel"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notifyBtn = findViewById<Button>(R.id.notify_btn)

        nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notifyBtn.setOnClickListener(){
            //Need
            //Intent - Where to land the user when they tap on the notification
            //Pending Intent - Helps get the intent the activity is heading to
            //Remote View - Inflation of the package and layout

            //
            val intent = Intent(this, NotificationActivity::class.java)
            val sIntent = Intent(this,
                NotificationActivity::class.java).apply{
                action = "Snooze"
                putExtra("snooze", 0)
            }

            val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            val spi = PendingIntent.getBroadcast(this, 0, sIntent, PendingIntent.FLAG_IMMUTABLE)
            val rv = RemoteViews(packageName, R.layout.activity_notification)

            //init the channel
            nc = NotificationChannel(cId, "Your reminders",
                NotificationManager.IMPORTANCE_HIGH).apply {
                enableLights(true)
                lightColor = Color.CYAN
                enableVibration(false)
            }

            nm.createNotificationChannel(nc)

            nb = Notification.Builder(this, cId).apply {
                setContentIntent(pi)
                setSmallIcon(R.drawable.ic_launcher_foreground)
                setContentTitle("First Notification")
                setContentText("LET GOOOO!!!!!")
                addAction(R.drawable.ic_baseline_snooze_24, "Snooze 10", spi)
            }

            nm.notify(111,nb.build())

        }
    }
}


//Notifications
//1 Part of core Android
//2 Notification manager
//3 Android 8 plus will have/need Notification channel
//4 Notification Builder