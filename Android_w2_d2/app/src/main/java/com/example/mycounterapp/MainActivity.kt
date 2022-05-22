package com.example.mycounterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.widget.Button

/*
important attributes in xml
id
layout height and width
gravity
padding
margin
layout x and y
orientation


LinerLayout
    id
    layout height and width
    orientation
    gravity
    background
    baselineAligned
    divider

RelativeLayout
    id
    gravity
    layout_above
    layout_alignTop/Right/Bottom/Left
    layout_alightParentTop/Right/Bottom/Left

TableLayout
    id
    CollapseColumns
    shrinkColumns
    stretchColumns

AbsoluteLayout
    id
    layout_x/y

FrameLayout
    id
    foreground
    foregroundGravity
    measureAllChildren

ConstraintLayout



 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("cycle", "In onCreate")
        //Button Actions
        counterText.setText("0")
       /* bttn0.setOnClickListener {
            counterText.append("0")
            Log.d("plus", "Inside plus")
        }
        bttn1.setOnClickListener {
            counterText.append("1")
            Log.d("plus", "Inside plus")
        }
        bttn2.setOnClickListener {
            counterText.append("2")
            Log.d("plus", "Inside plus")
        }
        bttn3.setOnClickListener {
            counterText.append("3")
            Log.d("plus", "Inside plus")
        }
        bttn4.setOnClickListener {
            counterText.append("4")
            Log.d("plus", "Inside plus")
        }
        bttn5.setOnClickListener {
            counterText.append("5")
            Log.d("plus", "Inside plus")
        }
        bttn6.setOnClickListener {
            counterText.append("6")
            Log.d("plus", "Inside plus")
        }
        bttn7.setOnClickListener {
            counterText.append("7")
            Log.d("plus", "Inside plus")
        }
        bttn8.setOnClickListener {
            counterText.append("8")
            Log.d("plus", "Inside plus")
        }
        bttn9.setOnClickListener {
            counterText.append("9")
            Log.d("plus", "Inside plus")
        }
        bttnPlus.setOnClickListener {
            counterText.append("+")
            Log.d("plus", "Inside plus")
        }
        bttnSub.setOnClickListener {
            counterText.append("-")
            Log.d("minus", "Inside minus")
        }
        bttnMul.setOnClickListener {
            counterText.append("*")
            Log.d("minus", "Inside minus")
        }
        bttnDiv.setOnClickListener {
            counterText.append("÷")
            Log.d("minus", "Inside minus")
        }
        bttnPerc.setOnClickListener {
            counterText.append("%")
            Log.d("minus", "Inside minus")
        }
        bttnDec.setOnClickListener {
            counterText.append(".")
            Log.d("minus", "Inside minus")
        }
        bttnNeg.setOnClickListener {

        }
        bttnEqu.setOnClickListener {
            var hasOpp = false
            var firstN = "0"
            var secN = "0"
            var opp = '+'
            for(i in counterText.text){
                if(i.isDigit() || i == '.'){
                    secN += i
                }else{
                    if(hasOpp){
                        val tF = firstN.toDouble()
                        val tS = secN.toDouble()
                        when(opp){
                            '+' -> firstN = (tF + tS).toString()
                            '-' -> firstN = (tF - tS).toString()
                            '*' -> firstN = (tF * tS).toString()
                            '÷' -> firstN = (tF / tS).toString()
                        }
                        opp = i
                        secN ="0"

                    }else{
                        firstN=secN
                        secN="0"
                        opp = i
                        hasOpp = true
                    }
                }
                val tF = firstN.toDouble()
                val tS = secN.toDouble()
                when(opp){
                    '+' -> firstN = (tF + tS).toString()
                    '-' -> firstN = (tF - tS).toString()
                    '*' -> firstN = (tF * tS).toString()
                    '÷' -> firstN = (tF / tS).toString()
                }

                counterText.setText(firstN)
            }
            Log.d("minus", "Inside minus")
        }*/
        bttnClear.setOnClickListener {
            counterText.text = ""
            Log.d("minus", "Inside minus")
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d("cycle", "In onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("cycle", "In onResume")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("cycle", "In onRestart")
    }
    override fun onPause() {
        super.onPause()
        Log.d("cycle", "In onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("cycle", "In onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("cycle", "In onDestroy")
    }
    //When an activity begins to stop, this gets called automatically
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        //
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //
    }
    fun testClick(view: View) {
        Log.d("click", "Click listeners from xml")
    }
    fun onDigit(view: View){

        counterText.append((view as Button).text)
    }
    fun onEquals(view: View) {

        var hasOpp = false
        var firstN = "0"
        var secN = "0"
        var opp = '+'
        for (i in counterText.text) {
            if (i.isDigit() || i == '.') {
                secN += i
            } else {
                if (hasOpp) {
                    Log.d("math", "$firstN, $secN")
                    val tF = firstN.toDouble()
                    val tS = secN.toDouble()

                    when (opp) {
                        '+' -> {firstN = (tF + tS).toString()}
                        '-' -> {firstN = (tF - tS).toString()}
                        '*' -> {firstN = (tF * tS).toString()}
                        '÷' -> {firstN = (tF / tS).toString()}
                    }
                    opp = i
                    secN = "0"
                } else {
                    firstN = secN
                    secN = "0"
                    opp = i
                    hasOpp = true
                }
            }


        }
        val tF = firstN.toDouble()
        val tS = secN.toDouble()
        when (opp) {
            '+' -> {firstN = (tF + tS).toString()}
            '-' -> {firstN = (tF - tS).toString()}
            '*' -> {firstN = (tF * tS).toString()}
            '÷' -> {firstN = (tF / tS).toString()}
        }

            counterText.text = (firstN)
/*

        var str = counterText.text
        var digitArray = str.split("*","+","-","÷","%")
        var opArray = str.split("[0-9]+".toRegex())
        var result = digitArray[0].toDouble()

        for(i in 1..digitArray.lastIndex){
            when(opArray[i]){
            "+" -> result += digitArray[i].toDouble()
            "-" -> result -= digitArray[i].toDouble()
            "*" -> result *= digitArray[i].toDouble()
            "÷" -> result /= digitArray[i].toDouble()
            "%" -> result %= digitArray[i].toDouble()
            }
        }
        counterText.text = result.toString()
*/
    }
}
