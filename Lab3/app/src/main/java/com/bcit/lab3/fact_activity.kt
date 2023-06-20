package com.bcit.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class fact_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fact)

        val factTextView = findViewById<TextView>(R.id.fact_textView)
        val factImageView = findViewById<ImageView>(R.id.imageView_factActivity)

        factTextView.text = intent.getStringExtra(TEXTFACT)
        factImageView.setImageResource(intent.getSerializableExtra(IMAGE) as Int)
    }
}