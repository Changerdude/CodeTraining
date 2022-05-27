package com.example.myfirstretro

import okhttp3.RequestBody

class PlayerRepository(private val inter : RetroApiInterface) {

    suspend fun getAllPlayers() = inter.getAllPlayers()

    suspend fun createPlayer(requestBody: RequestBody) = inter.createPlayer(requestBody)
}