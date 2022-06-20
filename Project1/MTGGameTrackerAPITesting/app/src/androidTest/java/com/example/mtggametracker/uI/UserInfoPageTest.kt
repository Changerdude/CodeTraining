package com.example.mtggametracker.uI

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
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
        onView(withId(R.id.searchText))
            .perform(typeText("Kur"))

    }


}