package com.example.myfirstretro

object Sample {
    fun validPlayer(player: Player): Boolean {
        if (player.playerId != null && player.name != null) {
            return true
        }
        return false

    }
}