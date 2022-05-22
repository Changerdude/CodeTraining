package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_input_screen.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.File
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.FileOutputStream


class InputScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_screen)
        bttnSave.setOnClickListener {


            val oldFile = JSONObject(Game.getJsonFromAssets("game.json", this))
            var array = oldFile.getJSONArray("games")
            var newEntry = JSONObject()
            newEntry.put("name", nameField.text)
            newEntry.put("splashArt", "")
            newEntry.put("timeSpent", timeTotal.text)
            newEntry.put("timeSpentWeekly", timeWeekly.text)
            newEntry.put("moneySpent", moneySpent.text)
            newEntry.put("numFriendPlay", numFriends.text)
            newEntry.put("daysPlayed", arrayOf("mon","tue","wed","thu","fri","sat","sun"))
            array.put(newEntry)

            var newFile = JSONObject()
            newFile.put("games", array)


//           val gsonPretty = GsonBuilder().setPrettyPrinting().create()
//            val strFile: String = gsonPretty.toJson(newFile.toString())
//            FileOutputStream("MyGames.json").write(strFile.toByteArray())
//            FileOutputStream("MyGames.json").close()





            val intentInput = Intent(this, MainActivity::class.java)

            startActivity(intentInput)
        }
        bttnBack.setOnClickListener {
            val intentInput = Intent(this, MainActivity::class.java)

            startActivity(intentInput)
        }
    }
}