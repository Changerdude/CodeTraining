package com.example.mtggametracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mtggametracker.data.*

class UserInfoPage : AppCompatActivity() {
    val repo: PlayerRepository by lazy {
        PlayerRepository(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_page)

        var playerList = repo.getAllPlayers()

        var rcView: RecyclerView = findViewById(R.id.playersView)
        rcView.layoutManager = LinearLayoutManager(this)

        val adapter = PlayerAdapter(playerList)

        rcView.adapter = adapter

    }

    fun setOnClick(){

    }
}