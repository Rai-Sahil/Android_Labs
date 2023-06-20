package com.bcit.async

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bcit.async.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val infoViewModel: InfoViewModel by viewModels()

        val button = binding.buttonMain
        button.setOnClickListener{
            infoViewModel.genericLiveData.value = 111
            infoViewModel.genericCallbackData.value = 111
        }

        binding.myPrintClass = SomePrintClass()

        val viewModel: UsersViewModel by viewModels()
        binding.myViewModel = viewModel



    }
}

class SomePrintClass {
    var mStr = "Print Something"

    fun printSomething(str:String){
        println(str)
    }
}