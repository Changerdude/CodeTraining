package com.example.myfirstretro

import com.example.myfirstretro.Sample.validPlayer
import junit.framework.Assert.assertEquals

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SampleTest {

    @Test
    fun validPlayerTest(){
        val player= Player(2,"aaa",0,0,0,0)
        assertEquals(true, validPlayer(player))
    }
    @Test
    fun validEmptyPlayerTest(){
        val player= Player(2,null,0,0,0,0)
        assertEquals(false, validPlayer(player))
    }
}

