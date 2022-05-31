package com.example.mtggametracker.uI

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.mtggametracker.MtgVM
import com.example.mtggametracker.R


class NewPlayer : AppCompatActivity() {
    lateinit var vm: MtgVM
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_player)
        vm =  MtgVM(application)
        val bnAddPlayer: Button = findViewById(R.id.bnAddPlayer)
        bnAddPlayer.isClickable = false

        val newPlayerName: EditText = findViewById(R.id.editTextNewPlayer)
        val bnCancel: Button = findViewById(R.id.bnCancel)
        bnAddPlayer.backgroundTintList = getColorStateList(R.color.grey)
        var wasTyped = false

        bnAddPlayer.setOnClickListener(){
            if(wasTyped) {
                vm.addNewPlayer(newPlayerName.text.toString())
                Toast.makeText(
                    this, "${newPlayerName.text} was added",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(Intent(this, UserInfoPage::class.java))
            } else {
                bnAddPlayer.isClickable = false
            }
        }
        bnCancel.setOnClickListener(){
            startActivity(Intent(this,UserInfoPage::class.java))
        }
        newPlayerName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                bnAddPlayer.isClickable = false
            }


            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        newPlayerName.requestFocus()
                        newPlayerName.setError("Must have name!")
                        bnAddPlayer.isClickable = false
                        bnAddPlayer.backgroundTintList = getColorStateList(R.color.grey)
                    } else {
                        bnAddPlayer.isClickable = true
                        bnAddPlayer.backgroundTintList = getColorStateList(R.color.burnt_o)
                        wasTyped = true


                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
}
