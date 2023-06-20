package com.bcit.lec3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

const val EXTRA = "com.bcit.lec3.SOMEDATA"

class MainActivity : AppCompatActivity() {

    //Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Activity Life cycle", "Main Activity on create ")
        Log.i("Activity Life cycle", "SavedInstanceState : $savedInstanceState")

        println(intent.extras?.size())
    }

    override fun onStart() {
        super.onStart()
        Log.i("Activity Life cycle", "Main Activity on start ")
    }

    override fun onResume(){
        super.onResume()
        Log.i("Activity Life cycle", "Main Activity on resume ")
    }

    override fun onPause(){
        super.onPause()
        Log.i("Activity Life cycle", "Main Activity on pause ")
    }

    override fun onStop(){
        super.onStop()
        Log.i("Activity Life cycle", "Main Activity on stop ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity Life cycle", "Main Activity on destroy ")
    }

    fun goToNextScreen(view: View){
        val intent = Intent(this, InfoActivity::class.java)
        intent.putExtra(EXTRA, "World")
        startActivity(intent)
    }
}