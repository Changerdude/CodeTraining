package com.example.espresso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

//UI Testing
//1 Add Depend
//2 Look at annotation and use cases
//3 Very Basic Example ( Get view, perform action, verify/assert)
// ViewMatchers - ViewActions -- ViewAssertions