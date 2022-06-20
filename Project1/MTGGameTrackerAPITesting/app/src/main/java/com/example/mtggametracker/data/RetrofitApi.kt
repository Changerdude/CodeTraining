package com.example.mtggametracker.data


import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitApi {

    //@GET is a http request method
//    @GET("players.json")
//    suspend fun getAllPlayers(): Response<List<Player>>
//    @POST("/post")
//    suspend fun createPlayer(@Body requestBody: RequestBody): Response<ResponseBody>
//    @POST("/v4/spreadsheets/" + :request)
//    suspend fun deletePlayer(request : String)
//    @PUT
//    suspend fun updatePlayer()

    //https://changerdude.github.io/players.json
    companion object{
        var BASE_URL = "https://changerdude.github.io/"
        fun create() : RetrofitApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitApi::class.java)
        }
    }
}