package com.example.myfirstretro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class InputForm : AppCompatActivity() {
    lateinit var vm : MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_form)
        vm = MyViewModel(application)

        val bnAdd : Button = findViewById(R.id.bnAdd)
        val bnCancel : Button = findViewById(R.id.bnCancel)
        val textInput : EditText = findViewById(R.id.text)

        bnAdd.setOnClickListener(){
            var myIntent = Intent(this, MainActivity::class.java)
//            myIntent.putExtra("inputText" , textInput.text.toString())
//            myIntent.putExtra("isAdding" , true)
         //   vm.addNewPlayer(textInput.text.toString())

            startActivity(myIntent)
        }
        bnCancel.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}