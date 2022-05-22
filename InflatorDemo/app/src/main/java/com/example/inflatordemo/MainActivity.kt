package com.example.inflatordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var main: LinearLayout = findViewById(R.id.main)
        var LI :LayoutInflator = LayoutInflator.from(this)

    }
}