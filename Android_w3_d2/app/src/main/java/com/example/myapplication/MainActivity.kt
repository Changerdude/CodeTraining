package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    private lateinit var vm: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        vm = ViewModelProvider(this)[MyViewModel::class.java]

        vm.getTimer().observe(this) {
            textView.text = it
        }
    }
}