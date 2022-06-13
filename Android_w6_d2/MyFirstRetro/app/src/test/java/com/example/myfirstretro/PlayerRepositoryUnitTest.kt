package com.example.myfirstretro

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.subscribeBy
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


@RunWith(JUnit4::class)
class PlayerRepositoryUnitTest {

    lateinit var repo: PlayerRepository

    @Mock
    lateinit var  inter: RetroApiInterface

    @Mock
    lateinit var dao: PlayerDAO

    @Before
    fun setup(){
        MockitoAnnotations.openMocks(this)
        repo = PlayerRepository(inter,dao)

    }
    @Test
    fun getAllPlayersFromApiTest(){
        var fakeList: List<Player> = listOf<Player>(
            Player(null,"Backer",0,0,0,0),
            Player(null,"Sacker",0,0,0,0)
        )


        Mockito.`when`(inter.getAllApiPlayers())
            .thenReturn(Single.just(fakeList))

        var result = repo.getAllPlayerFromApi()
        Assert.assertEquals(fakeList, result.subscribeBy(
            onNext = {
                Assert.assertEquals(listOf<Player>(
                    Player(null,"Backer",0,0,0,0),
                    Player(null,"Sacker",0,0,0,0)
                ), it)
            },
            onError = { println("Error: $it") }
        ))
    }
    //Use runblocking to test a coroutine
//    @Test
//    fun coroutineExampleTest(){
//        runBlocking {
//            var fakeList: List<Player> = listOf<Player>(
//                Player(null, "Backer", 0, 0, 0, 0),
//                Player(null, "Sacker", 0, 0, 0, 0)
//            )
//
//
//            Mockito.`when`(inter.getAllApiPlayers())
//                .thenReturn(Single.just(fakeList))
//
//            var result = repo.getAllPlayerFromApi()
//            Assert.assertEquals(fakeList, result.subscribeBy(
//                onNext = {
//                    Assert.assertEquals(fakeList, it)
//                },
//                onError = { println("Error: $it") }
//            ))
//        }
//    }
}