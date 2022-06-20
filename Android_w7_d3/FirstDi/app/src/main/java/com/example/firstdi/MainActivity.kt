package com.example.firstdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val vm: BooksVm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        observeBooks()
    }

    fun observeBooks(){
        vm.booksList.observe(this){
            println(it)
        }
    }
}

//1 Bring in depend
//2 Create app class
//3 add class to manifest file name

//1 Model
//2 Interface
//3 Repo