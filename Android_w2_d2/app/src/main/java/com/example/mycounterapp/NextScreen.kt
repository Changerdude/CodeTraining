package com.example.mycounterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_next_screen.*

class NextScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_screen)

        backScreen.setOnClickListener {
            val intentBack = Intent(this, MainActivity::class.java)

            startActivity(intentBack)
        }
    }
}