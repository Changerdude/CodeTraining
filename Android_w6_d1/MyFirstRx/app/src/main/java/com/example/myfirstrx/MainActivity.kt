package com.example.myfirstrx


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var obs = io.reactivex.Observable.create<Int>{ sub ->
            println("start")
            sub.onNext(6)
            sub.onNext(7)
            sub.onNext(8)
            sub.onComplete()
            println("Complete")

        }

        var observer =  object: Observer<Int> {
            override fun onSubscribe(p0: Disposable){
                println("subbed")
            }
            override fun onNext(p0: Int){
                println("next")
            }
            override fun onError(p0: Throwable){
                println("error")
            }
            override fun onComplete(){
                println("completed")
            }

        }

        obs.subscribe(observer)

        io.reactivex.Observable.just(5,6,7)
            .map{":-)".repeat(it) }
            .subscribe{println(it)}
    }
}