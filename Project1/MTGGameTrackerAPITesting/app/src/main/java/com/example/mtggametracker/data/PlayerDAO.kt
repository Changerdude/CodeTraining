package com.example.mtggametracker.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlayerDAO {

    @Insert
  fun addPlayer(player: Player)
    @Query("select * from players order by playerId desc")
    fun selectPlayers(): LiveData<List<Player>>
//  TODO: Add the query for the search functionality
    @Query("select * from players where name like '%' || :searchText || '%'")
    fun searchPlayers(searchText: String?): List<Player>

    @Query("select * from players order by case when :isAsc = 1 then name end asc," +
            " case when :isAsc = 0 then name end desc")
    fun orderName(isAsc: Boolean): List<Player>

    @Query("select * from players order by case when :isAsc = 1 then gamesPlayed end asc," +
            " case when :isAsc = 0 then gamesPlayed end desc")
    fun orderPlayed(isAsc: Boolean): List<Player>

    @Query("select * from players order by case when :isAsc = 1 then gamesWon end asc," +
            " case when :isAsc = 0 then gamesWon end desc")
    fun orderWon(isAsc: Boolean): List<Player>

    @Query("select * from players order by case when :isAsc = 1 then percentWon end asc," +
            " case when :isAsc = 0 then percentWon end desc")
    fun orderPerc(isAsc: Boolean): List<Player>

    @Query("select * from players order by case when :isAsc = 1 then playerKills end asc," +
            " case when :isAsc = 0 then playerKills end desc")
    fun orderKills(isAsc: Boolean): List<Player>

    @Query("select * from players order by case when :isAsc = 1 then playerMoos end asc," +
            " case when :isAsc = 0 then playerMoos end desc")
    fun orderMoos(isAsc: Boolean): List<Player>

    @Update
    fun updatePlayer(player: Player)

    @Delete
    fun deletePlayer(player: Player)

    @Query("DELETE FROM players")
    fun deleteAll()
}