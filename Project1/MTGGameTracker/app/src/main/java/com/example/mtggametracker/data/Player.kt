package com.example.mtggametracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "players")
data class Player(@PrimaryKey(autoGenerate = true)var playerId: Int?,
                  @ColumnInfo(name = "name")var name: String?,
                  @ColumnInfo(name = "gamesPlayed")var gamesPlayed: Int?,
                  @ColumnInfo(name = "gamesWon")var gamesWon: Int?,
                  @ColumnInfo(name = "percentWon")var percentWon: Int?,
                  @ColumnInfo(name = "playerKills")var playerKills: Int?,
                  @ColumnInfo(name = "playerMoos")var playerMoos: Int?
                  ): Serializable

