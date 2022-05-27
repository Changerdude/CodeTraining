package com.example.mtggametracker.uI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.example.mtggametracker.MtgVM
import com.example.mtggametracker.R
import com.example.mtggametracker.data.Player
import com.google.android.material.drawable.DrawableUtils

class UpdatePlayer : AppCompatActivity() {
    lateinit var vm: MtgVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_player)
        vm = MtgVM(application)


        val bnUpdate: Button = findViewById(R.id.playerUpdate)
        val bnDelete: Button = findViewById(R.id.playerDelete)
        val bnBack: Button = findViewById(R.id.updateBack)

        val name : EditText = findViewById(R.id.playerName)
        val gamesPlayed : EditText = findViewById(R.id.gamesPlayed)
        val gamesWon : EditText = findViewById(R.id.gamesWon)
        val playerKills : EditText = findViewById(R.id.playerKills)
        val playerMoos : EditText = findViewById(R.id.playerMoos)

        var player: Player = intent.getSerializableExtra("player") as Player
        name.setText(player.name.toString())
        gamesPlayed.setText(player.gamesPlayed.toString())
        gamesWon.setText(player.gamesWon.toString())
        playerKills.setText(player.playerKills.toString())
        playerMoos.setText(player.playerMoos.toString())

        bnUpdate.setOnClickListener() {

                vm.updatePlayer(
                    Player(
                        player.playerId,
                        name.text.toString(),
                        Integer.parseInt(gamesPlayed.text.toString()),
                        Integer.parseInt(gamesWon.text.toString()),
                        Integer.parseInt(playerKills.text.toString()),
                        Integer.parseInt(playerMoos.text.toString())
                    )
                )
                startActivity(Intent(this, UserInfoPage::class.java))

        }
        bnDelete.setOnClickListener(){
            vm.deletePlayer(player)
            startActivity(Intent(this, UserInfoPage::class.java))
        }
        bnBack.setOnClickListener(){
        startActivity(Intent(this, UserInfoPage::class.java))
        }


        name.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        name.requestFocus()
                        name.setError("Must have name!")
                    } else {
                        bnUpdate.isClickable = true
                    }
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        name.requestFocus()
                        name.setError("Must have name!")
                        bnUpdate.isClickable = false
                    } else {
                        bnUpdate.isClickable = true
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        gamesPlayed.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        gamesPlayed.requestFocus()
                        gamesPlayed.setError("Must have a Value")
                        bnUpdate.isClickable = false
                    } else {
                        bnUpdate.isClickable = true
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        gamesWon.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        gamesWon.requestFocus()
                        gamesWon.setError("Must have a Value")
                        bnUpdate.isClickable = false
                    } else if(p0.toString().toInt() > gamesPlayed.text.toString().toInt()) {
                        gamesWon.requestFocus()
                        gamesWon.setError("Cannot Win more games than played")
                        bnUpdate.isClickable = false

                    } else {
                        bnUpdate.isClickable = true
                    }
                }

            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        playerKills.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        playerKills.requestFocus()
                        playerKills.setError("Must have a Value")
                        bnUpdate.isClickable = false
                    } else {
                        bnUpdate.isClickable = true
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        playerMoos.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        playerMoos.requestFocus()
                        playerMoos.setError("Must have a Value")
                        bnUpdate.isClickable = false
                    } else {
                        bnUpdate.isClickable = true
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })

    }
}