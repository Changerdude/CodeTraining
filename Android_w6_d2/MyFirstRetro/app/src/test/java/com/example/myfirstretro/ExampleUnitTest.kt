package com.example.myfirstretro

import org.junit.*
import android.app.Application

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Before
    fun atBefore(){

    }
    @BeforeClass
    fun atBeforeClass(){

    }
    @After
    fun atAfter(){

    }
    @AfterClass
    fun atAfterClass(){

    }
}