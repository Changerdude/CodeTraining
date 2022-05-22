package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val repo: StudentRepository by lazy {
        StudentRepository(this)
    }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)




            var buttonInsert: View = findViewById(R.id.plus)
            buttonInsert.setOnClickListener(){
                val insertIntent = Intent(this, InsertNewStudent::class.java)

                startActivity(insertIntent)
            }

            var studentList = repo.getAllStudents()

            var rcView: RecyclerView = findViewById(R.id.rcView)
            rcView.layoutManager = LinearLayoutManager(this)
            // pass to adapter
            val adapter = StudentAdapter(studentList)


            val swipeGesture = object : SwipeGesture() {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                   adapter.deleteItem(viewHolder.adapterPosition, repo)
                }
            }
            val touchHelper = ItemTouchHelper(swipeGesture)
            touchHelper.attachToRecyclerView(rcView)
            rcView.adapter = adapter
        }

}



