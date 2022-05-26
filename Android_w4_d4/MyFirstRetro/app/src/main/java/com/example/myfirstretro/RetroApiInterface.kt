package com.example.myfirstretro

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

interface RetroApiInterface {
//    companion object {
//        var INSTANCE: AppDatabase? = null
//
//        fun getInstance(context: Context) :AppDatabase?{
//            //If not created, create it
//            if( INSTANCE == null){
//                //Rule: Acquire instance of RoomDB
//                //We are acquiring an instance of RoomDB Builder
//                synchronized(AppDatabase::class){
//                    INSTANCE = Room.databaseBuilder(context.applicationContext,
//                        AppDatabase::class.java, "students.db")
//                        .allowMainThreadQueries().build()
//                }
//            }
//
//            return INSTANCE
//        }
//
//        fun destroyInstance(){
//            INSTANCE = null
//        }
//
//    }


    @GET("players.json")
    fun getAllPlayers(): Call<List<Player>>


    companion object{
        var BASE_URL = "https://changerdude.github.io/"
        fun create() : RetroApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroApiInterface::class.java)
        }
    }
}