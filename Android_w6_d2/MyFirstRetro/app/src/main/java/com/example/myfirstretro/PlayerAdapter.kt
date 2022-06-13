package com.example.myfirstretro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(var playerList: List<Player>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_list_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cPlayer = playerList[position]

        holder.playerName.text = cPlayer.name
        holder.gamesPlayed.text = "Played: ${cPlayer.gamesPlayed}"
        holder.gamesWon.text = "Won: ${cPlayer.gamesWon}"
        holder.playerKills.text = "Kills: ${cPlayer.playerKills}"
        holder.playerMoos.text = "Moos: ${cPlayer.playerMoos}"

    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    fun setPlayers(playerList: List<Player>){
        this.playerList = playerList
        notifyDataSetChanged()
    }
}
class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    val playerName : TextView = view.findViewById(R.id.name)
    val gamesPlayed : TextView = view.findViewById(R.id.gamesPlayed)
    val gamesWon : TextView = view.findViewById(R.id.gamesWon)
    val playerKills : TextView = view.findViewById(R.id.playerKills)
    val playerMoos : TextView = view.findViewById(R.id.playerMoos)

}