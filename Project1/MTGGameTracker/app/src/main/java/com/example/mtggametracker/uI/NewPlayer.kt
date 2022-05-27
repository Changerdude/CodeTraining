package com.example.mtggametracker.uI

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        val bnCancel: Button = findViewById(R.id.bnCancel)

        bnAddPlayer.setOnClickListener(){
            vm.addNewPlayer(newPlayerName.text.toString())
            startActivity(Intent(this,UserInfoPage::class.java))
        }
        bnCancel.setOnClickListener(){
            startActivity(Intent(this,UserInfoPage::class.java))
        }
        newPlayerName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }


            @SuppressLint("ResourceAsColor")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0 != null) {
                    if(p0.isEmpty()){
                        newPlayerName.requestFocus()
                        newPlayerName.setError("Must have name!")
                        bnAddPlayer.isClickable = false
                        bnAddPlayer.setBackgroundColor(R.color.grey)
                    } else {
                        bnAddPlayer.isClickable = true
                        bnAddPlayer.setBackgroundColor(R.color.purple_700)


                    }
                }
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
}