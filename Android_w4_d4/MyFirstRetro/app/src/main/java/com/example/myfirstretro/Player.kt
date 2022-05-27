package com.example.myfirstretro


data class Player(var name : String, var gamesPlayed : Int,
                  var gamesWon : Int, var playerKills : Int,
                  var playerMoos : Int) {
}

//Form will all the fields from the entity
//When user submits, get all filled Data
//Create JSONObject using data filled
//Convert that json to string
//convert the string to request body