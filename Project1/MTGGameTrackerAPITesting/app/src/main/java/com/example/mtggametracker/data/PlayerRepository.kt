package com.example.mtggametracker.data

import android.content.Context
import android.icu.text.StringSearch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PlayerRepository(context: Context) {
    var db: PlayerDAO? = AppDatabase.getInstance(context)?.getDao()

  fun getAllPlayers(): LiveData<List<Player>>? {
        return db?.selectPlayers()
    }

    //TODO: Search Functionality
    fun searchPlayers(searchText: String?): List<Player>?{
       return db?.searchPlayers(searchText)
    }

   fun addPlayer(player: Player){
        db?.addPlayer(player)
    }

    fun orderName(isAsc: Boolean): List<Player>?{
        return db?.orderName(isAsc)
    }
    fun orderPlayed(isAsc: Boolean): List<Player>?{
        return db?.orderPlayed(isAsc)
    }
    fun orderWon(isAsc: Boolean): List<Player>?{
        return db?.orderWon(isAsc)
    }
    fun orderPerc(isAsc: Boolean): List<Player>?{
        return db?.orderPerc(isAsc)
    }
    fun orderKills(isAsc: Boolean): List<Player>?{
        return db?.orderKills(isAsc)
    }
    fun orderMoos(isAsc: Boolean): List<Player>?{
        return db?.orderMoos(isAsc)
    }

    fun updatePlayer(player: Player){
        db?.updatePlayer(player)
    }

    fun deletePlayer(player: Player){
        db?.deletePlayer(player)
    }

}