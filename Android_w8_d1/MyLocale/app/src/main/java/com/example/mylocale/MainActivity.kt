package com.example.mylocale


import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var config : Configuration
    private lateinit var lang : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Programmatically change locale
        val bnEng: Button = findViewById(R.id.eng)
        val bnDeu: Button = findViewById(R.id.deu)
        val testImage : ImageView = findViewById(R.id.image)

       // testImage.setBackgroundResource(R.drawable.test)
        testImage.setImageDrawable(getDrawable(R.drawable.test))

        config = baseContext.resources.configuration

        bnEng.setOnClickListener(){
            changeLocale(Locale.ENGLISH)
        }
        bnDeu.setOnClickListener() {
            changeLocale(Locale.GERMAN)
        }

        //Change LTR to RTL
//        lang = "ar"
//        var loc = Locale(lang)
//        config.apply{
//            setLocale(loc)
//            setLayoutDirection(loc)
//            window.decorView.layoutDirection = if(lang == "ar") View.LAYOUT_DIRECTION_RTL else View.LAYOUT_DIRECTION_LTR
//        }
//        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)


    }

    private fun changeLocale(l: Locale){
        config.apply{
            setLocale(l)
            setLayoutDirection(l)
            window.decorView.layoutDirection = if(l == Locale("ar")) View.LAYOUT_DIRECTION_RTL else View.LAYOUT_DIRECTION_LTR
        }
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
            recreate()
        }
    }



// Can Identify the language of preference based on setting in phone
// If you have a "strings" file that is appropriate for the language setting
// it should automatically switch to the translated strings


// RTL
//Min sdk 17
//android:supportRtl = "true"
// left and right reversed
// Device < 4.2 Start and End reversed as well

//in terms of places where mirroring is an issue
//ldrtl( res/drawable-ldrtl/ic-back.xml)