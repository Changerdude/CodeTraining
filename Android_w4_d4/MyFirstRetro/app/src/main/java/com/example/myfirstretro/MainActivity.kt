package com.example.myfirstretro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.MediaType
import okhttp3.RequestBody.*
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var vm : MyViewModel
    var adapter = PlayerAdapter(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        vm = MyViewModel()
        vm.playerList.observe(this){
            adapter.setPlayers(it)
        }
        vm.getAllPlayers()

        val rcView: RecyclerView = findViewById(R.id.rcView)

        //adapter.setPlayers(vm.playerList.value)
            rcView.adapter = adapter
        rcView.layoutManager = LinearLayoutManager(this@MainActivity)

        val bnAdd : Button = findViewById(R.id.bnAdd)
        bnAdd.setOnClickListener(){
            startActivity(Intent(this, InputForm::class.java))
        }
        var isAdding = intent.getBooleanExtra("isAdding", false)
        if(isAdding) {
            var s: String = intent.getStringExtra("inputText")!!
            var p = Player(s,0,0,0,0)

            val gsonPretty = GsonBuilder().setPrettyPrinting().create()
            val pJson : String = gsonPretty.toJson(p)
            vm.createPlayer(pJson.toRequestBody())
        }

    }
}

//Needs to use retrofit
//1.Dependencies
//2.Internet Permission in policy
//Create an entity
//3.Create retrofit instance
//4.Create a retrofit Interface for all our request methods
//5.Consume the rest API endpoints (response - success/error)
//6.Process and attach it to your view (Recycler View)