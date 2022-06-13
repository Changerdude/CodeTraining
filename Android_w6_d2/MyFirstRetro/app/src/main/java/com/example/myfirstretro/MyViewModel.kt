package com.example.myfirstretro


import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.RequestBody



class MyViewModel(app : Application): ViewModel() {
        private val repo = PlayerRepository(RetroApiInterface.create(), AppDatabase.getInstance(app)!!
            .getDao())
        var playerList = MutableLiveData<List<Player>>()
        lateinit var obs : Observable<List<Player>>


//        fun getAllPlayers(){
//            CoroutineScope(Dispatchers.IO).launch {
//                var res = repo.getAllPlayers()
//                if(res.isSuccessful){
//                    playerList.postValue(res.body())
//                }
//            }
//        }

        fun getAllApiPlayers() : Observable<List<Player>>{

               return repo.getAllApiPlayers()

        }

        fun addNewPlayer(name: String) = viewModelScope.launch {
        var player = Player(
            playerId = null, name = name, gamesPlayed = 0,
            gamesWon = 0, playerKills = 0,
            playerMoos = 0)


            repo.addPlayer(player)


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