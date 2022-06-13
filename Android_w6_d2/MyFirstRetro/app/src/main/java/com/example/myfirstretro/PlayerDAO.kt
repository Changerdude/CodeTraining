package com.example.myfirstretro

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface PlayerDAO {

    @Query("select * from players")
    fun getAllPlayers(): Single<List<Player>>

    @Insert
    fun addPlayer(player: Player)


}