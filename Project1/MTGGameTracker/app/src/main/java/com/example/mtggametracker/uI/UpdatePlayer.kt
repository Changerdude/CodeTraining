package com.example.mtggametracker.uI

import android.R.attr.data
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.mtggametracker.MtgVM
import com.example.mtggametracker.R
import com.example.mtggametracker.data.Player


class UpdatePlayer : AppCompatActivity() {
    lateinit var bnUpdate: Button
    lateinit var bnDelete: Button
    lateinit var vm: MtgVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_player)
        vm = MtgVM(application)


        bnUpdate = findViewById(R.id.playerUpdate)
        bnDelete = findViewById(R.id.playerDelete)
        val bnBack: Button = findViewById(R.id.updateBack)

        val name : EditText = findViewById(R.id.playerName)
        val gamesPlayed : EditText = findViewById(R.id.gamesPlayed)
        val gamesWon : EditText = findViewById(R.id.gamesWon)
        val playerKills : EditText = findViewById(R.id.playerKills)
        val playerMoos : EditText = findViewById(R.id.playerMoos)
        val mooing : TextView = findViewById(R.id.txtMoos)

        var player: Player = intent.getSerializableExtra("player") as Player
        name.setText(player.name.toString())
        gamesPlayed.setText(player.gamesPlayed.toString())
        gamesWon.setText(player.gamesWon.toString())
        playerKills.setText(player.playerKills.toString())
        playerMoos.setText(player.playerMoos.toString())

        bnUpdate.setOnClickListener() {
            val dialog = AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_delete)
                .setTitle("Update")
                .setMessage("Updating will replace old data, are you sure?")
                .setPositiveButton("Update"){ dialog, which ->
                    vm.updatePlayer(
                        Player(
                            player.playerId,
                            name.text.toString(),
                            Integer.parseInt(gamesPlayed.text.toString()),
                            Integer.parseInt(gamesWon.text.toString()),
                            if(Integer.parseInt(gamesPlayed.text.toString()) == 0 ){
                                   0
                            }else{
                                ((gamesWon.text.toString().toDouble().div(
                                    gamesPlayed.text.toString().toDouble())).times(100)).toInt()
                            },
                            Integer.parseInt(playerKills.text.toString()),
                            Integer.parseInt(playerMoos.text.toString())
                        )
                    )
                    Toast.makeText(this, "${player.name} was updated",
                        Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, UserInfoPage::class.java))
                }.setNegativeButton("Cancel"){dialog, which ->
                }.create()
                .show()


        }

        mooing.setOnClickListener(){
            val dialog = AlertDialog.Builder(this)
                .setTitle("Redirecting")
                .setMessage("This will launch YouTube, are you sure?")
                .setPositiveButton("Continue"){ dialog, which ->
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ZiqRKlpsavA")))
                }.setNegativeButton("Cancel"){dialog, which ->
                }.create()
                .show()

        }
        bnDelete.setOnClickListener(){
            val dialog = AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_delete)
                .setTitle("Delete")
                .setMessage("Are you sure you want to delete?")
                .setPositiveButton("Delete"){ dialog, which ->
                    vm.deletePlayer(player)
                    Toast.makeText(this, "${player.name} was deleted",
                        Toast.LENGTH_SHORT).show()

                    startActivity(Intent(this, UserInfoPage::class.java))
                }.setNegativeButton("Cancel"){dialog, which ->
                }.create()
                .show()
        }

        bnBack.setOnClickListener(){
        startActivity(Intent(this, UserInfoPage::class.java))
        }


        name.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        name.requestFocus()
                        name.setError("Must have name!")
                        availableButton(false)
                    } else {
                        availableButton(true)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        gamesPlayed.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        gamesPlayed.requestFocus()
                        gamesPlayed.setError("Must have a Value")
                        availableButton(false)
                    } else {
                        availableButton(true)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        gamesWon.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        gamesWon.requestFocus()
                        gamesWon.setError("Must have a Value")
                        availableButton(false)
                    } else if(p0.toString().toInt() > gamesPlayed.text.toString().toInt()) {
                        gamesWon.requestFocus()
                        gamesWon.setError("Cannot Win more games than played")
                        availableButton(false)

                    } else {
                        availableButton(true)
                    }
                }

            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        playerKills.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        playerKills.requestFocus()
                        playerKills.setError("Must have a Value")
                        availableButton(false)
                    } else {
                        availableButton(true)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        playerMoos.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        playerMoos.requestFocus()
                        playerMoos.setError("Must have a Value")
                        availableButton(false)
                    } else {
                        availableButton(true)
                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })

    }
    @RequiresApi(Build.VERSION_CODES.M)
    fun availableButton(isAvailable : Boolean){
        if(isAvailable){
            bnUpdate.isClickable = true
            bnUpdate.backgroundTintList = getColorStateList(R.color.burnt_o)

        } else {
            bnUpdate.isClickable = false
            bnUpdate.backgroundTintList = getColorStateList(R.color.grey)
        }
    }
}