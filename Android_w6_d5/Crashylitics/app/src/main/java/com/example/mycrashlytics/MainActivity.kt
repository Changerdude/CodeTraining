package com.example.mycrashlytics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import timber.log.Timber
import java.lang.Exception
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var crashlytics = Firebase.crashlytics
        crashlytics.setUserId("112Jeffry")
        try {
            throw RuntimeException("Oh why!?")
        } catch(e: Exception){
            crashlytics.recordException(e)
        }

    }
}