package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bn1 : Button = findViewById(R.id.bn1)
        val bn2 : Button = findViewById(R.id.bn2)

        bn1.setOnClickListener(){
            setFragment(Fragment1())
        }
        bn2.setOnClickListener(){
            setFragment(Fragment2())
        }

    }
    fun setFragment(fragment: Fragment){
        var fm = supportFragmentManager
        var ft = fm.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()
    }
}

// Fragments

// AJAX
//async javascript xml http request

//1 What is a fragment
//2 Why Fragments
//  2.1 Create Fragments
//3 How to pass data from one fragment to another
//4 Sharing of data( from activity to fragment and vise versa)
//5 Top app bar
//6 Bottom bar
//7 Navigation Drawer