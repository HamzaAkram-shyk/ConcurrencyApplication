package com.example.myapplication.concurency

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.lang.Exception

class Demo {
    lateinit var diff:Deferred<Int>
    var count:Int=0
    suspend fun getStream() :Int{
        coroutineScope {
            launch(IO){
                delay(3000)
                count=4
            }
            diff= async (IO){
                delay(6000)
                return@async 50
            }
        }
        return count+diff.await()
    }
}