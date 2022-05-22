package com.example.myapplication

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private var currentTime = MutableLiveData<String>()
    private var myTimer = object : CountDownTimer(20000, 1000) {

        override fun onTick(millisUntilFinished: Long) {
            currentTime.value = "seconds remaining: " + millisUntilFinished / 1000
        }

        override fun onFinish() {
            currentTime.value = "done!"
        }
    }.start()

    fun getTimer(): MutableLiveData<String> = currentTime
}
