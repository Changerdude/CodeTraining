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



            //Find and initialize button to insert Student
            var buttonInsert: View = findViewById(R.id.plus)
            buttonInsert.setOnClickListener(){
                val insertIntent = Intent(this, InsertNewStudent::class.java)

                startActivity(insertIntent)
            }

            var studentList = repo.getAllStudents()

            var rcView: RecyclerView = findViewById(R.id.rcView)
            rcView.layoutManager = LinearLayoutManager(this)
            // pass studentlist to adapter as our adapter
            val adapter = StudentAdapter(studentList)

            //Override on swipe function to go to delete item in adapter class
            val swipeGesture = object : SwipeGesture() {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                   adapter.deleteItem(viewHolder.adapterPosition, repo)
                }
            }
            //Attach the touch helper to our recyclerview or the list
            val touchHelper = ItemTouchHelper(swipeGesture)
            touchHelper.attachToRecyclerView(rcView)
            //Attach our adapter to the recyclerview adapter
            rcView.adapter = adapter
        }

}



