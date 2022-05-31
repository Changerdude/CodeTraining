package com.example.mtggametracker.uI


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mtggametracker.MtgVM
import com.example.mtggametracker.R
import com.example.mtggametracker.data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async


class UserInfoPage : AppCompatActivity() {
    lateinit var vm: MtgVM
    lateinit var adapter: PlayerAdapter
    private var playerList = ArrayList<Player>()
    lateinit var searchList: ArrayList<Player>
    var isSearching = false
    var isAsc = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_page)
        vm = MtgVM(application)
        val dropDown : Spinner = findViewById(R.id.dropdownMenu)
        val bnSort : ImageButton = findViewById(R.id.ascendDescend)
        val noPlayer : TextView = findViewById(R.id.noPlayers)
        val progress : ProgressBar = findViewById(R.id.progressBar)

        var dAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.sort_by_list,
            R.layout.spinner_item
        )
        dropDown.adapter = dAdapter
        dropDown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                adapter.dropPosition = position
                adapter.setOrder(vm)
            }

        }




        vm.allPlayers.observe(this) {
            getPlayers(it)
        }
        vm.getAllPlayers()

        var rcView: RecyclerView = findViewById(R.id.playersView)
        rcView.layoutManager = LinearLayoutManager(this)

        adapter = PlayerAdapter({position -> onPlayerClick(position)},playerList)
        adapter.isAsc = isAsc

        rcView.adapter = adapter
        var search: SearchView = findViewById(R.id.searchText)

        search.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                var searchResult = vm.searchPlayers(p0) as List<Player>?
                adapter.setPlayers(searchResult)
                searchList = vm.searchPlayers(p0) as ArrayList<Player>


                adapter.notifyDataSetChanged()

                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                isSearching = p0 != null
                var searchResult = vm.searchPlayers(p0) as List<Player>?
                adapter.setPlayers(searchResult)
                searchList = vm.searchPlayers(p0) as ArrayList<Player>
                    if(searchList.size == 0){
                        rcView.isVisible = false
                        noPlayer.isVisible = true
                    } else {
                        rcView.isVisible = true
                        noPlayer.isVisible = false
                    }
                adapter.notifyDataSetChanged()
                return false
            }


        })
        bnSort.setOnClickListener() {
            if (isAsc) {
                isAsc = false
                adapter.isAsc = isAsc
                adapter.setOrder(vm)
                bnSort.scaleY = (1).toFloat()
            } else if (!isAsc) {
                isAsc = true
                adapter.isAsc = isAsc
                adapter.setOrder(vm)
                bnSort.scaleY = (-1).toFloat()
            }
            dropDown.onItemSelectedListener
        }



    }

    fun addPlayer(view: View){startActivity(Intent(this, NewPlayer::class.java))}

    fun back(view: View){startActivity(Intent(this , MainMenu::class.java))}



    private fun getPlayers(playerList: List<Player>) {
        this.playerList.clear()
        this.playerList.addAll(playerList)
        adapter.notifyDataSetChanged()
    }

    private fun onPlayerClick(position: Int) {
        val myIntent = Intent (this, UpdatePlayer::class.java)
        if(isSearching) {
            myIntent.putExtra("player", searchList[position])
        } else {
            myIntent.putExtra("player", playerList[position])
        }
        startActivity(myIntent)

    }
}

