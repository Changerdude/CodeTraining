package com.example.espresso

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(AndroidJUnit4::class)
class BlankFragmentTest{

    @Test
    fun verifyText(){
        launchFragmentInContainer<BlankFragment>()

        onView(withId(R.id.myFragmentText)).check(matches(withText("Hello blank fragment")))


    }
}
