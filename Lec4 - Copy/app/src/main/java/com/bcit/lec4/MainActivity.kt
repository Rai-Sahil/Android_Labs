package com.bcit.lec4

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.StudentAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener(MyOnClickListener(this,"Good Morning"))

        //Another way of adding button
        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener{
            var btn = it as Button
            println(it.text)
        }

        //Interface shit
        val btn4 = findViewById<Button>(R.id.button3)
        btn4.setOnClickListener(this)

        setUpRecyclerView()
    }

    private class MyOnClickListener(var activity: Activity, var str:String) : View.OnClickListener{

        override fun onClick(v: View?) {
            val textView = activity.findViewById<TextView>(R.id.textView)
            textView.text = str
        }

    }

    override fun onClick(v: View?) {
        println("This is where the activity implements the interface")
    }

    fun setUpRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val students = listOf<String>("Billy", "Sarah", "Joanna", "Alex", "Minnie")

        recyclerView.adapter = StudentAdapter(students)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}