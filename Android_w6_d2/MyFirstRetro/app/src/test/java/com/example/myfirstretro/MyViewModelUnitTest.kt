package com.example.myfirstretro

import android.app.Application
import io.mockk.impl.annotations.MockK
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MyViewModelUnitTest {
//    @Mock
//    @Before
//    @Test
//    @After
//
//
    lateinit var vm: MyViewModel

    @Mock
    lateinit var repo: PlayerRepository

    @Mock
    lateinit var dao: PlayerDAO

    @Mock
    lateinit var inter: RetroApiInterface

    @Mock
    lateinit var context: Application

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        repo = PlayerRepository(inter,dao)
        vm = MyViewModel(context)
    }

    @Test
    fun getAllApiPlayersTest(){
        var fakeList: List<Player> = listOf<Player>(
            Player(null,"Backer",0,0,0,0),
            Player(null,"Sacker",0,0,0,0)
        )
        Mockito.`when`(repo.getAllApiPlayers())
            .thenReturn(Observable.fromArray(fakeList))
        val result = vm.getAllApiPlayers()
        assertEquals(fakeList, result.subscribeBy(
            onNext = {
                assertEquals(fakeList,it)},
            onError = {println("Error: $it")}
        ))
    }
    @Test
    fun `given repository when calling playerList then list is empty and assert its empty`(){

    }
}

//1 Add all dependancies
//2 Add Class annotations

//Given
//3 Identify all the external dependancy and note it down
//4 Create any local objects needed
//5 MockK all the identified dependancies (@Mock, @Before)

// When
//   Call respective function on your mocked object
//   from the function that needs to be tested

//Then
// Return Dummy
// Make the actual call -- which is verify

// And
// assert