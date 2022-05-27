package com.example.mtggametracker.uI


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mtggametracker.R
import com.example.mtggametracker.data.*

class PlayerAdapter(private val onPlayerClick: (position:Int) -> Unit, private var playerList: List<Player>): RecyclerView.Adapter<ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_info, parent, false)
        return ViewHolder(view , onPlayerClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = playerList[position]
        holder.infoViewName.text = player.name
        holder.infoViewPlayed.text = player.gamesPlayed.toString()
        holder.infoViewWon.text = player.gamesWon.toString()

                if (player.gamesPlayed == 0) {
                    holder.infoViewPerc.text = "0"
                } else {
                    holder.infoViewPerc.text = player.gamesWon?.toDouble()?.div(player.gamesPlayed?.toDouble()!!)
                        ?.times(100)?.toInt().toString()
                }

        holder.infoViewKills.text = player.playerKills.toString()
        holder.infoViewMoos.text = player.playerMoos.toString()
    }

    override fun getItemCount(): Int {

        return playerList.size
    }

    fun setPlayers(playerList: List<Player>){
        this.playerList = playerList
        notifyDataSetChanged()
    }



}
class ViewHolder(view: View , var onPlayerClick: (position: Int) -> Unit)
        : RecyclerView.ViewHolder(view) , View.OnClickListener{
    init{
        itemView.setOnClickListener(this)
    }
    val infoViewName: TextView = view.findViewById(R.id.infoViewName)
    val infoViewPlayed: TextView = view.findViewById(R.id.infoViewPlayed)
    val infoViewWon: TextView = view.findViewById(R.id.infoViewWon)
    val infoViewPerc: TextView = view.findViewById(R.id.infoViewPerc)
    val infoViewKills: TextView = view.findViewById(R.id.infoViewKills)
    val infoViewMoos: TextView = view.findViewById(R.id.infoViewMoos)

   //TODO: Add click listener for recyclerview
   override fun onClick(v: View?) {
       val position = adapterPosition
       onPlayerClick(position)
   }

}

