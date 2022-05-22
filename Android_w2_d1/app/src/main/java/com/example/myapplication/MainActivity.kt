package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class Calc(a:Int ,b:Int) {
    var a = a
    var b = b
    var res = 0
    fun sum(a: Int, b: Int) {
        res = a + b

    }

    fun sub(a: Int, b: Int) {
        res = a + b

    }

    fun mul(a: Int, b: Int) {
        res = a + b

    }

    fun divide(a: Int, b: Int) {
        res = a + b

    }

}