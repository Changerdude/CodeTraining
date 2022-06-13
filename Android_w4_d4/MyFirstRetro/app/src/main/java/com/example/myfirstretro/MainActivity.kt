package com.example.myfirstretro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody



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
            val pJson : String = gsonPretty.toJson(p.toString())
            vm.createPlayer(pJson.toRequestBody("application/json".toMediaTypeOrNull()))
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

//Quality Code
//1 Coding standards ( Space, UPPERCASE, camelCase, TitleCase)
//2 Doc on top of every file
//3 //On top of every function oneliner explaining what it is
//4 Exception handling
//5 Logging & Crashlytics & Sonarqube
//6 Clean Architecture - Adheres to a design pattern which is MVVM in our case
//7 Write Unit Test Cases and make sure at least you have 70% coverage
//8 Remove all println in production app
//9 Do not log or print sensitive information
//10 Do not let the Log in production environment(Production App)