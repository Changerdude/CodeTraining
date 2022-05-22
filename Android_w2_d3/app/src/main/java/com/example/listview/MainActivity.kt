package com.example.listview
/*

form with 3 fields of the JSON
button to save a json
 */
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import com.google.gson.GsonBuilder
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bttnInputScreen.setOnClickListener {
            val intentInput = Intent(this, InputScreen::class.java)

            startActivity(intentInput)
        }

        listView = findViewById(R.id.nameListView)
        //var game = Game("", "", "", 0, 0.0, 0)
//        if( !File("MyGames.json").exists()){
//            val gsonPretty = GsonBuilder().setPrettyPrinting().create()
//            val strFile: String =
//                gsonPretty.toJson((Game.getJsonFromAssets("game.json", this)).toString())
//            FileOutputStream("sdcard/Documents/game.json").write(strFile.toByteArray())
//            // FileOutputStream("sdcard/Documents/game.json").close()
//        }
       var gameItemList = Game.getGameItems("game.json", this)

//         var listItems = arrayOfNulls<String>(gameItemList.size)
////        var i =0
////        for(item in gameItemList){
////            listItems[i++] = item.name
////        }/sdcard/Documents
//        //OR
////        for(i in 0..gameItemList.lastIndex){
////            listItems[i] = gameItemList[i].name
////        }
//        //OR
//        for(i in 0 until gameItemList.size){
//            val currGame = gameItemList[i]
//            listItems[i] = currGame.name
//        }
        val adapter = GameAdapter(this, gameItemList)
        //View <---> Adapter <--> DataSource
        listView.adapter = adapter
    }
}