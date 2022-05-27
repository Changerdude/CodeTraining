package com.example.mtggametracker

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mtggametracker.data.Player
import com.example.mtggametracker.data.PlayerRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MtgVM(app: Application): ViewModel() {
    val repo: PlayerRepository
    var allPlayers : LiveData<List<Player>>

    init {
        repo = PlayerRepository(app)
        allPlayers = repo.getAllPlayers()!!
    }

    fun getAllPlayers() = viewModelScope.launch  {
        repo.getAllPlayers() ?: listOf<Player>()
    }

    fun addNewPlayer(name: String) = viewModelScope.launch {
            repo.addPlayer(
                Player(
                    playerId = null, name = name, gamesPlayed = 0,
                    gamesWon = 0, playerKills = 0, playerMoos = 0))
    }

    //TODO: Believe search functionality here too

    fun updatePlayer(player: Player) = viewModelScope.launch  {
        repo.updatePlayer(player)
    }

    fun deletePlayer(player: Player) = viewModelScope.launch  {
        repo.deletePlayer(player)
    }
}