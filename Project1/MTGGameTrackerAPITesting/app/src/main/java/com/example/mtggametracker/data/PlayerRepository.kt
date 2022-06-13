package com.example.mtggametracker.data

import android.content.Context
import android.icu.text.StringSearch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.RequestBody

class PlayerRepository(context: Context, private val inter : RetrofitApi) {
    var db: PlayerDAO? = AppDatabase.getInstance(context)?.getDao()
    //TODO will need a way to get/make/input this for seperate groups
    var sheetId : String = "1Jzl_rSNZZewgjZYwqNgiROblp1gOM3hjQVU8uObMi-Y"

    //If retrofit get players returns players, reload database with those values, if not return
    // toast saying could not sync and to reload app later.

  suspend fun getAllPlayers(): LiveData<List<Player>>? {
      if(inter.getAllPlayers().isSuccessful){
          db?.deleteAll()
          for(i in 0..(inter.getAllPlayers().body()?.size!!)){
              db?.addPlayer(inter.getAllPlayers().body()!![i])
          }
      }

          return db?.selectPlayers()

    }


    fun searchPlayers(searchText: String?): List<Player>?{
       return db?.searchPlayers(searchText)
    }

   suspend fun addPlayer(player: Player , rB : RequestBody){
        db?.addPlayer(player)
        inter.createPlayer(rB)
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

    suspend fun updatePlayer(player: Player){
        db?.updatePlayer(player)
        inter.updatePlayer(sheetId + "/values/" + player.name)
    }

    suspend fun deletePlayer(player: Player){
        db?.deletePlayer(player)
        inter.deletePlayer(sheetId + "/values/" + player.name)
    }

}