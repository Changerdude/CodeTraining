package com.example.mtggametracker.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PlayerRepository(context: Context) {
    var db: PlayerDAO? = AppDatabase.getInstance(context)?.getDao()

  fun getAllPlayers(): LiveData<List<Player>>? {
        return db?.selectPlayers()
    }

    //TODO: Search Functionality
   fun addPlayer(player: Player){
        db?.addPlayer(player)
    }

    fun updatePlayer(player: Player){
        db?.updatePlayer(player)
    }

    fun deletePlayer(player: Player){
        db?.deletePlayer(player)
    }

}