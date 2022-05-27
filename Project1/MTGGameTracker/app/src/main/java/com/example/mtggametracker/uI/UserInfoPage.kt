package com.example.mtggametracker.uI
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mtggametracker.MtgVM
import com.example.mtggametracker.R
import com.example.mtggametracker.data.*

class UserInfoPage : AppCompatActivity() {
    lateinit var vm: MtgVM
    lateinit var adapter: PlayerAdapter
    private var playerList = ArrayList<Player>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_page)
        vm = MtgVM(application)

        vm.allPlayers?.observe(this) {
            getPlayers(it)
        }
        vm.getAllPlayers()
        var rcView: RecyclerView = findViewById(R.id.playersView)
        rcView.layoutManager = LinearLayoutManager(this)

        adapter = PlayerAdapter({position -> onPlayerClick(position)},playerList)

        rcView.adapter = adapter

    }
    //TODO: Add search functionality
    fun addPlayer(view: View){startActivity(Intent(this, NewPlayer::class.java))}

    fun back(view: View){startActivity(Intent(this , MainMenu::class.java))}

    private fun getPlayers(playerList: List<Player>) {
        this.playerList.clear()
        this.playerList.addAll(playerList)
        adapter.notifyDataSetChanged()
    }

    private fun onPlayerClick(position: Int) {
        val myIntent = Intent (this, UpdatePlayer::class.java)
        myIntent.putExtra("player", playerList[position])
        startActivity(myIntent)

    }
}