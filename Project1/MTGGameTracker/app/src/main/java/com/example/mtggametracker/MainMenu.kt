package com.example.mtggametracker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startGame: View = findViewById(R.id.startGame)
        startGame.setOnClickListener(){
            startActivity(Intent(this, MainMenu::class.java))}

        var playerInfo: View = findViewById(R.id.viewInfo)
        playerInfo.setOnClickListener(){
            startActivity(Intent(this, UserInfoPage::class.java))}
    }
}
