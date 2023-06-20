package com.bcit.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    fun setupRecyclerView(){
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView_main)
        var resources = listOf<Cartoon>(
            Cartoon("spongebob", R.drawable.spongebob),
        Cartoon("Patrick", R.drawable.patrick),
        Cartoon("pearl", R.drawable.pearl),
        Cartoon("sandy", R.drawable.sandy),
        Cartoon("krabs", R.drawable.krabs),
            Cartoon("squidward", R.drawable.squidward))

        recyclerView.adapter = CartoonAdapter(resources)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }
}