package com.example.mtggametracker.data

import android.icu.text.StringSearch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface PlayerDAO {

    @Insert
  fun addPlayer(player: Player)

    @Query("select * from players")
    fun selectPlayers(): LiveData<List<Player>>
//  TODO: Add the query for the search functionality
//    @Query("select * from players where search like name")
//    fun searchPlayer(search: StringSearch): List<Player>

    @Update
    fun updatePlayer(player: Player)

    @Delete
    fun deletePlayer(player: Player)
}