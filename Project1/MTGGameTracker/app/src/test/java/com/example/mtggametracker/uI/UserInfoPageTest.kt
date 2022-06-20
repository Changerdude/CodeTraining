package com.example.mtggametracker.uI

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class UserInfoPageTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(UserInfoPage::class.java)

    @Before
    fun setup(){

    }

    @After
    fun tearDown(){

    }

    @Test
    fun checkMainActivity(){

    }


}
}