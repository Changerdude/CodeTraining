package com.example.mtggametracker.uI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.mtggametracker.MtgVM
import com.example.mtggametracker.R


class NewPlayer : AppCompatActivity() {
    lateinit var vm: MtgVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_player)
        vm =  MtgVM(application)
        val bnAddPlayer: Button = findViewById(R.id.bnAddPlayer)
        val newPlayerName: EditText = findViewById(R.id.editTextNewPlayer)

        bnAddPlayer.setOnClickListener(){
            vm.addNewPlayer(newPlayerName.text.toString())
            startActivity(Intent(this,UserInfoPage::class.java))
        }
    }
}