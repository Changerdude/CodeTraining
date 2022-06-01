package com.example.mtggametracker.uI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mtggametracker.R

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    fun startGame(view: View){startActivity(Intent(this, MainMenu::class.java))}

    fun playerInfo(view: View){startActivity(Intent(this, UserInfoPage::class.java))}
}
