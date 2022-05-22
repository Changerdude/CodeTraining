package com.example.listview

import android.content.Context
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class GameAdapter(val context: Context, val gameList: ArrayList<Game>): BaseAdapter() {
    //LayoutInflator
    //Create a new view out of an xml layout
    //findViewById just refers to a view that has already been created
    //when calling setContentView(R.layout.activity_main) in the onCreate, that initalizes that view
    val inflater = LayoutInflater.from(context)

    override fun getCount(): Int {

        return gameList.size
    }
    override fun getItem(p0: Int): Any {
        return gameList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, parent: ViewGroup?): View {

        val view:View
        val holder: ViewHolder

        view = inflater.inflate(R.layout.expanded_info, parent, false)


        holder = ViewHolder()
        holder. nameViewView = view.findViewById(R.id.nameView) as TextView
        holder. splashView = view.findViewById(R.id.splash) as ImageView
        holder. moneyView = view.findViewById(R.id.money) as TextView
        holder. totalHView = view.findViewById(R.id.totalHours) as TextView
        holder. weeklyHView = view.findViewById(R.id.weeklyHours) as TextView

        view.tag = holder

        val game = getItem(p0) as Game

        holder.nameViewView.text = game.name
        Picasso.get().load(game.splashArt).placeholder(R.drawable.ic_launcher_background).into(holder.splashView)
        holder.weeklyHView.text = (game.timeSpentWeekly).toString()
        holder.totalHView.text = game.timeSpent
        holder.moneyView.text = (game.moneySpent).toString()


            return view
    }
    private class ViewHolder {
        lateinit var nameViewView: TextView
        lateinit var splashView: ImageView
        lateinit var moneyView: TextView
        lateinit var totalHView: TextView
        lateinit var weeklyHView: TextView

    }
}
