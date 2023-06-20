package com.bcit.lec3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView


class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        Log.i("Activity Life cycle", "info Activity on create ")

        val bundle = Bundle();
        //bundle.putString("KEY 1")

        var v = findViewById<TextView>(R.id.textView)
        v.text = intent.getStringExtra(EXTRA)
        println(intent.getStringExtra(EXTRA))

        setupSpinner()

    }

    override fun onStart() {
        super.onStart()
        Log.i("Activity Life cycle", "info Activity on start ")
    }

    override fun onResume(){
        super.onResume()
        Log.i("Activity Life cycle", "Info Activity on resume ")
    }

    override fun onPause(){
        super.onPause()
        Log.i("Activity Life cycle", "info Activity on pause ")
    }

    override fun onStop(){
        super.onStop()
        Log.i("Activity Life cycle", "info Activity on stop ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity Life cycle", "info Activity on destroy ")
    }

    fun showData(view : View){

    }

    fun setupSpinner(){

        val spinner = findViewById<Spinner>(R.id.spinner)
        val countries = arrayOf("Canada", "USA", "China", "India")

        //Adapter bridge our data with UI
        val arrAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)

        //What does dropdown view looklike
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrAdapter

    }
}