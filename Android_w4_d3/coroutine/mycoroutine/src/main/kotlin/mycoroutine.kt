import kotlin.concurrent.thread
import kotlinx.coroutines.*

fun main(){
//    println("test")
//
    println("Main program is running in: ${Thread.currentThread().name}")
    runBlocking {
        println("Program is running in: ${Thread.currentThread().name}")
//    //Main will say, "thread take care of this" and skip over the code block
//    thread{
//        println("This is another thread: ${Thread.currentThread().name}")
//        Thread.sleep(4000) //Demonstrate some work being done
//        println("This is after 1000 mills: ${Thread.currentThread().name}")
//    }
//
//    println("Main End in: ${Thread.currentThread().name}")
//    delay(2000)
//        val job:Job = launch{
//            //do any work
//        }
//
//        job.cancel()
//
//        val i:Deferred<Int> = async { //if you want to return some value
//            1
//        }
//        println(i.await())
//        runBlocking {
//
//        }//usecase to test suspend functions


//        val j: Job = GlobalScope.launch {
//            println("Hey I am inside a coroutine running in t: ${Thread.currentThread().name}")
//            mySuspendFun(100)//Some amount of work
//            println("This is Coroutine after sleep 1 in t: ${Thread.currentThread().name}")
//            mySuspendFun(100)//Some amount of work
//            println("This is Coroutine after sleep 2 in t: ${Thread.currentThread().name}")
//            mySuspendFun(100)//Some amount of work
//            println("This is Coroutine after sleep 3 in t: ${Thread.currentThread().name}")
//            mySuspendFun(100)//Some amount of work
//            println("This is Coroutine after sleep 4 in t: ${Thread.currentThread().name}")
//            mySuspendFun(100)//Some amount of work
//            println("This is Coroutine after sleep 5 in t: ${Thread.currentThread().name}")
//        }
        // Thread.sleep(3000) //Should be dynamic, not a static wait
        //Dont end before the cor finish
        //j.join() //Finish j's job before continuing in the coroutine "runBlocking" that the main is wrapped in
//        mySuspendFun(400)
        //j.cancel() //Ends j coroutine
        val j: Job = GlobalScope.launch {
            for (i in 0..2000){
                println(i)
                yield() // Adds a suspend function to make the coroutine cooperative
            }
        }

        j.cancelAndJoin()
        val d: Deferred<Int> = GlobalScope.async {
            2+3
        }

        println(d.await())
        println("Main End in: ${Thread.currentThread().name}")
    }
//    val j = GlobalScope.launch ( start = CoroutineStart.LAZY ){
//        delay(300)
//        println("I am the lazy one")
//        delay(200)
//    }
//    GlobalScope.launch {
//        delay(100)
//        println("Normal coroutine")
//        j.join() // This is how you find whether your coroutine has finished executing
//        println("Third message")
//        delay(100)
//    }
//    Thread.sleep(1000)

}
suspend fun mySuspendFun(t: Long){
    delay(t) //Could be a retrofit call to the server
}