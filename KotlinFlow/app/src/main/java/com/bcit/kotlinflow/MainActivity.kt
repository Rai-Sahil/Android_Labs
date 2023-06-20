package com.bcit.kotlinflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bcit.kotlinflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        // As over here the layout of this class is usually set to this xml, but we wanna change that
        setContentView(binding.root)

        //Bindings are type safe
        binding.buttonMain.setOnClickListener{
            println("Good Morning")
        }
        //binding class won't be able to find the thing which doesn't have any ID's

        binding.myPrintClass = SomePrintClass()
    }
}


class SomePrintClass {
    var mStr = "Print Something"

    fun printSomething(str:String){
        println(str)
    }
}