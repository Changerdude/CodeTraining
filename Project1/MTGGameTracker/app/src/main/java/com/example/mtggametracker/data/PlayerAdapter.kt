package com.example.mtggametracker.data


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mtggametracker.R

class PlayerAdapter(private val playerList: List<Player>): RecyclerView.Adapter<ViewHolder>(){
    private var mplayerList: MutableList<Player> = playerList as MutableList<Player>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_info, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = mplayerList[position]
        holder.infoViewName.text = player.name
        holder.infoViewPlayed.text = player.gamesPlayed.toString()
        holder.infoViewWon.text = player.gamesWon.toString()
        holder.infoViewPerc.text = ((player.gamesWon?.div(player.gamesPlayed!!))
            ?.times(100)).toString()
        holder.infoViewKills.text = player.playerKills.toString()
        holder.infoViewMoos.text = player.playerMoos.toString()
    }

    override fun getItemCount(): Int {

        return mplayerList.size
    }



}
class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    val infoViewName: TextView = view.findViewById(R.id.infoViewName)
    val infoViewPlayed: TextView = view.findViewById(R.id.infoViewPlayed)
    val infoViewWon: TextView = view.findViewById(R.id.infoViewWon)
    val infoViewPerc: TextView = view.findViewById(R.id.infoViewPerc)
    val infoViewKills: TextView = view.findViewById(R.id.infoViewKills)
    val infoViewMoos: TextView = view.findViewById(R.id.infoViewMoos)

}