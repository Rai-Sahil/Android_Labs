package com.bcit.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        printSomeStuff()
    }

    fun printSomeStuff(){
        val scope = CoroutineScope(Dispatchers.Main)

        scope.launch() {
            println("Good Night")
        }
    }
}