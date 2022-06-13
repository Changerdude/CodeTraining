package com.example.myfirstretro


import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface RetroApiInterface {

//@GET is a http request method
    @GET("players.json")
   suspend fun getAllPlayers(): Single<List<Player>>
    @POST("/post")
    suspend fun createPlayer(@Body requestBody: RequestBody): Response<ResponseBody>
    @GET("players.json")
    fun getAllApiPlayers(): Single<List<Player>>

//https://changerdude.github.io/players.json
    companion object{
        var BASE_URL = "https://changerdude.github.io/"
        fun create() : RetroApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetroApiInterface::class.java)
        }
    }
}
//Creating an instance will always be a builder, an adapter/converter, then build.