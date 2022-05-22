package com.example.listview

import android.content.Context
import org.json.JSONObject
import kotlin.text.Charsets.UTF_8

class Game (val name: String,val splashArt: String,val timeSpent: String,val timeSpentWeekly: Int,val moneySpent: Double,val numFriendsPlay: Int, daysPlayed: Array<String>){

//    constructor(_name: String, _splashArt: String, _timeSpent: String, _timeSpentWeekly: Int, _moneySpent: Double, _numFriendsPlay: Int){
//        name = _name
//        splashArt = _splashArt
//        timeSpent = _timeSpent
//        timeSpentWeekly = _timeSpentWeekly
//        moneySpent = _moneySpent
//        numFriendsPlay = _numFriendsPlay
//
//    }

companion object {
    fun getGameItems(filename: String, context: Context): ArrayList<Game> {
        val gameItemList = ArrayList<Game>()
        val jsonStr = getJsonFromAssets(filename, context)
        println(jsonStr)
        // JSONObject
        val gameJson = JSONObject(jsonStr)
        val gameList = gameJson.getJSONArray("games")
        println(gameList)
        //map JSONArray to ArrayList
        (0 until gameList.length()).mapTo(gameItemList) {
            val fi = gameList.getJSONObject(it).getJSONArray("daysPlayed")

            Game(
                gameList.getJSONObject(it).getString("name"),
                gameList.getJSONObject(it).getString("splashArt"),
                gameList.getJSONObject(it).getString("timeSpent"),
                gameList.getJSONObject(it).getInt("timeSpentWeekly"),
                gameList.getJSONObject(it).getDouble("moneySpent"),
                gameList.getJSONObject(it).getInt("numFriendsPlay"),
                Array(fi.length()){fi.getString(it)}
            )
        }
        return gameItemList
    }

    fun getJsonFromAssets(filename: String, context: Context): String? {
        var jsonStr: String?
        // Open stream of bytes
        val inStream = context.assets.open(filename)
        // Get size of section of input stream
        val size = inStream.available()
        // make an array for the input steam bytes
        val buffer = ByteArray(size)

        inStream.read(buffer)
        inStream.close()
        jsonStr = String(buffer, UTF_8)
        return jsonStr
    }
}
}