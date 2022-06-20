package com.example.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

// Scenario and respective class injection
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup(){

    }

    @After
    fun tearDown(){

    }

    @Test
    fun checkMainActivity(){
        onView(withText("Hello World!"))  //ViewMatchers
            .check(                            //ViewActions
                matches(isDisplayed()))        //ViewAssertions

        onView(withId(R.id.myButton))
            .perform(click())
        onView(withId(R.id.myEditText))
            .perform(typeText("Automated"))

        onView(withId(R.id.myEditText))
            .perform(click(), clearText(), typeText("LetsGOOOOO"))
    }



}

// Every Test will have the following
// View - Perform -- Assert
// ViewMatchers - ViewActions -- ViewAssertions

