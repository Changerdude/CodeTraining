package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var vm: MyViewModel
    lateinit var adapter: StudentAdapter
    private var studentList = ArrayList<Students>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = MyViewModel(application)

        vm.allStudents?.observe(this) { studentList ->
            getStudents(studentList)
        }


        //Find and initialize button to insert Student
        val buttonInsert: View = findViewById(R.id.plus)
        buttonInsert.setOnClickListener {
            val myIntent = Intent (this, UpdateStudent::class.java)
            startActivity(myIntent)
        }


        val rcView: RecyclerView = findViewById(R.id.rcView)
        rcView.layoutManager = LinearLayoutManager(this)
        // pass studentList to adapter as our adapter
        adapter = StudentAdapter( {position -> onClick(position) },studentList)
        rcView.adapter = adapter

        //Override on swipe function to go to delete item in adapter class
        val swipeGesture = object : SwipeGesture() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //       adapter.deleteItem(viewHolder.adapterPosition, repo)
                adapter.deleteItem(viewHolder.adapterPosition, vm)
            }
        }
        //Attach the touch helper to our recyclerview or the list
        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(rcView)
        //Attach our adapter to the recyclerview adapter

    }


    private fun onClick(position: Int) {
        val myIntent = Intent (this, UpdateStudent::class.java)
        myIntent.putExtra("student", studentList[position])
        myIntent.putExtra("isEdit", true)
        startActivity(myIntent)

    }

    private fun getStudents(studentList: List<Students>) {
        this.studentList.clear()
        this.studentList.addAll(studentList)
        adapter.notifyDataSetChanged()
    }
}


