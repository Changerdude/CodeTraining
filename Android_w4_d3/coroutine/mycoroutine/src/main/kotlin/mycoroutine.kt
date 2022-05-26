import kotlin.concurrent.thread
import kotlinx.coroutines.*

fun main(){
//    println("test")
//
    println("Main program is running in: ${Thread.currentThread().name}")
//    //Main will say, "thread take care of this" and skip over the code block
//    thread{
//        println("This is another thread: ${Thread.currentThread().name}")
//        Thread.sleep(4000) //Demonstrate some work being done
//        println("This is after 1000 mills: ${Thread.currentThread().name}")
//    }
//
//    println("Main End in: ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("Hey I am inside a coroutine running in t: ${Thread.currentThread().name}")
        delay(2000)//Some amount of work
        println("This is Coroutine after sleep in t: ${Thread.currentThread().name}")
    }
    Thread.sleep(3000) //Should be dynamic, not a static wait
    //Dont end before the cor finish

    println("Main End in: ${Thread.currentThread().name}")


}
