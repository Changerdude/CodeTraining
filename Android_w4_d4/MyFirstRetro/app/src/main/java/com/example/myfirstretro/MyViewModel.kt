package com.example.myfirstretro


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.RequestBody



class MyViewModel(): ViewModel() {
        private val repo = PlayerRepository(RetroApiInterface.create())
        var playerList = MutableLiveData<List<Player>>()

        fun getAllPlayers(){
            CoroutineScope(Dispatchers.IO).launch {
                var res = repo.getAllPlayers()
                if(res.isSuccessful){
                    playerList.postValue(res.body())
                }
            }
        }

        fun createPlayer(requestBody: RequestBody){
            CoroutineScope(Dispatchers.IO).launch{
                var res =repo.createPlayer(requestBody)
                println("AAA")
                println(res.body()?.string())
                if(res.isSuccessful){
                    //res is now json
                    val gson = GsonBuilder().setPrettyPrinting().create()
                    val pJson = gson.toJson(
                        JsonParser.parseString(
                            res.body()?.string()
                        )
                    )
                    println(pJson)
                }
            }
        }
//        val api = RetroApiInterface.create().getAllPlayers()
//
//        api.enqueue(object : Callback<List<Player>> {
//            override fun onResponse(call: Call<List<Player>>, response: Response<List<Player>>) {
//                return (response)
//
//            }
//
//            override fun onFailure(call: Call<List<Player>>, t: Throwable) {
//                println("OH NO! Failure: $t")
//            }
//        })

}