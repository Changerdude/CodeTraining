package com.example.mtggametracker.data

import androidx.room.*

@Dao
interface PlayerDAO {

    @Insert
    fun addPlayer(player: Player)

    @Query("select * from players")
    fun selectPlayers(): List<Player>

    @Update
    fun updatePlayer(player: Player)

    @Delete
    fun deletePlayer(player: Player)
}