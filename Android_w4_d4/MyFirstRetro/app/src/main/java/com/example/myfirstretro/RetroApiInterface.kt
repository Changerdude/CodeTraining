package com.example.myfirstretro

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface RetroApiInterface {

//@GET is a http request method
    @GET("players.json")
   suspend fun getAllPlayers(): Response<List<Player>>
    @POST("/post")
    suspend fun createPlayer(@Body requestBody: RequestBody): Response<RequestBody>


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
//Creating an instance will always be a builder, an adapter/converter, then build.