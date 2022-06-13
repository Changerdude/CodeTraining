package com.example.myfirstretro

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import okhttp3.RequestBody

class PlayerRepository(private val inter : RetroApiInterface, private val dao: PlayerDAO) {

    suspend fun getAllPlayers() = inter.getAllPlayers()

fun getAllApiPlayers() : Observable<List<Player>> {
//        return inter.getAllApiPlayers()
    return Observable.concatArray(
        getAllPlayerFromApi(),
        getAllPlayerFromDb()
    )
    }

    suspend fun createPlayer(requestBody: RequestBody) = inter.createPlayer(requestBody)
    fun addPlayer(player: Player ){
        dao.addPlayer(player)

    }

    fun getAllPlayerFromApi() : Observable<List<Player>>{
        return inter.getAllApiPlayers().toObservable()
    }
    fun getAllPlayerFromDb() : Observable<List<Player>>{
        return dao.getAllPlayers()
            .toObservable()
            .filter{ it.isNotEmpty() }
            .doOnNext {
                //here is where we can add logging so its useful for debugging

            }
    }
}