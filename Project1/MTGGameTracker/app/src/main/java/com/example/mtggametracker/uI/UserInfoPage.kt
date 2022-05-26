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

        vm.allPlayers?.observe(this) { playerList ->
            getPlayers(playerList)
        }

        var rcView: RecyclerView = findViewById(R.id.playersView)
        rcView.layoutManager = LinearLayoutManager(this)

        adapter = PlayerAdapter(playerList)

        rcView.adapter = adapter

    }

    fun addPlayer(view: View){startActivity(Intent(this, NewPlayer::class.java))}

    private fun getPlayers(playerList: List<Player>) {
        this.playerList.clear()
        this.playerList.addAll(playerList)
        adapter.notifyDataSetChanged()
    }
}