package com.example.mycrashlytics

import android.util.Log
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import timber.log.Timber
import org.jetbrains.annotations.*


class ReleaseTree: @NotNull Timber.Tree(){
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR || priority == Log.WARN){
            //Send error reports to the crashlytics
            var crashlytics = Firebase.crashlytics
            crashlytics.setUserId("112Jeffry")
            crashlytics.log("this is the end")

        }

    }

}