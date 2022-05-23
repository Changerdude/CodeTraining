package com.example.mtggametracker.data

import android.content.Context

class PlayerRepository(context: Context) {
    var db: PlayerDAO? = AppDatabase.getInstance(context)?.getDao()

    fun getAllPlayers(): List<Player>{
        return db?.selectPlayers() ?: listOf<Player>()
    }

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