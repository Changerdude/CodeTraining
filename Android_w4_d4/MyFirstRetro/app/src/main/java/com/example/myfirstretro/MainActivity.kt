package com.example.myfirstretro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var adapter = PlayerAdapter(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rcView: RecyclerView = findViewById(R.id.rcView)


            rcView.adapter = adapter
        rcView.layoutManager = LinearLayoutManager(this@MainActivity)

        val api = RetroApiInterface.create().getAllPlayers()

        api.enqueue(object: Callback<List<Player>>{
            override fun onResponse(call: Call<List<Player>>, response: Response<List<Player>>) {
                println(response.body())
                adapter.setPlayers(response.body()!!)

            }

            override fun onFailure(call: Call<List<Player>>, t: Throwable) {
                println("OH NO! Failure: $t")
            }

        })


    }
}

//Needs to use retrofit
//1.Dependencies
//2.Internet Permission in policy
//3.Create retrofit instance
//4.Create a retrofit Interface for all our request methods
//5.Consume the rest API endpoints (response - success/error)
//6.Process and attach it to your view (Recycler View)