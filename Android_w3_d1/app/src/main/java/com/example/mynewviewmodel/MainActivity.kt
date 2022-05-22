package com.example.mynewviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import android.widget.Button as Button1

class MainActivity : AppCompatActivity() {
    lateinit var vm: MyViewModel
    lateinit var numberView: TextView
    lateinit var buttonPlus: Button1
    lateinit var buttonMinus: Button1
    lateinit var buttonRand: Button1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberView = findViewById(R.id.randomNumber)

        //Provider
        vm = ViewModelProvider(this)[MyViewModel::class.java]
       numberView.text = vm.getCount().toString()


        buttonMinus = findViewById(R.id.buttonMinus)
        buttonPlus = findViewById(R.id.buttonPlus)
        buttonRand = findViewById(R.id.buttonRand)

        vm.getNumber().observe(this){
            numberView.text = it.toString()
        }

        buttonMinus.setOnClickListener() {
            vm.decrementNumber()
        }

        buttonPlus.setOnClickListener() {
            vm.incrementNumber()
        }

        buttonRand.setOnClickListener() {
            vm.randomizeNumber()
        }


    }

}