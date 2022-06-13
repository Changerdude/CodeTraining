package com.example.mtggametracker

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mtggametracker.data.Player
import com.example.mtggametracker.data.PlayerRepository
import androidx.lifecycle.viewModelScope
import com.example.mtggametracker.data.RetrofitApi
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class MtgVM(app: Application): ViewModel() {
    private val repo: PlayerRepository
    var allPlayers : LiveData<List<Player>>

    init {
        repo = PlayerRepository(app, RetrofitApi.create())
        allPlayers = repo.getAllPlayers()!!
    }

    fun getAllPlayers() = viewModelScope.launch  {
        repo.getAllPlayers() ?: listOf<Player>()
    }

    fun addNewPlayer(name: String) = viewModelScope.launch {
        var player = Player(
            playerId = null, name = name, gamesPlayed = 0,
            gamesWon = 0, percentWon = 0, playerKills = 0,
            playerMoos = 0)


        repo.addPlayer(player, getRequestBody(player))


    }

    fun searchPlayers(searchText: String?): List<Player>?{
        return repo.searchPlayers(searchText)
    }

    fun orderName(isAsc: Boolean): List<Player>?{
        return repo.orderName(isAsc)
    }
    fun orderPlayed(isAsc: Boolean): List<Player>?{
        return repo.orderPlayed(isAsc)
    }
    fun orderWon(isAsc: Boolean): List<Player>?{
        return repo.orderWon(isAsc)
    }
    fun orderPerc(isAsc: Boolean): List<Player>?{
        return repo.orderPerc(isAsc)
    }
    fun orderKills(isAsc: Boolean): List<Player>?{
        return repo.orderKills(isAsc)
    }
    fun orderMoos(isAsc: Boolean): List<Player>?{
        return repo.orderMoos(isAsc)
    }
    //Going to add, request body form of player to param
    fun updatePlayer(player: Player) = viewModelScope.launch  {
        repo.updatePlayer(player, getRequestBody(player))
    }

    fun deletePlayer(player: Player) = viewModelScope.launch  {
        repo.deletePlayer(player, getRequestBody(player))
    }

    private fun getRequestBody(player : Player): RequestBody {
        val gsonPretty = GsonBuilder().setPrettyPrinting().create()
        val pJson : String = gsonPretty.toJson(player.toString())
        return pJson.toRequestBody()
    }
}