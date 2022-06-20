package com.example.excercises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1
        val sen = "fun&!! time"
        longestWord(sen)

        //2


    }
    //1
    fun longestWord(sen: String){
        var lengths = mutableListOf<Int>()
        var words = sen.split(' ').toMutableList()
        for(i in 0..words.lastIndex){
            words[i] = words[i].replace("\\p{Punct}".toRegex(), "")
            lengths.add(i,words[i].length)
        }

        var winner = 0
        var winlen = 0
        for(i in 0..lengths.lastIndex){
            if(lengths[i] > winlen){
                winlen = lengths[i]
                winner = i
            }
        }
        println(words.toString())
        println(words[winner])

    }
}

