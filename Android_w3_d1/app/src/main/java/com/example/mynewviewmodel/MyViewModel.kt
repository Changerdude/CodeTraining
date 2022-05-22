package com.example.mynewviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MyViewModel: ViewModel() {
    //Our Logic belongs here
    private var count = (1000 until 9999).random()
    private var num = MutableLiveData<Int>()




    fun getNumber(): MutableLiveData<Int> = num

    fun incrementNumber() {
        num.value = ++count

    }
    fun decrementNumber() {
        num.value = --count
    }


    fun randomizeNumber(){
        count = (1000 until 9999).random()
        num.value = count
    }
    fun getCount(): Int = count
}