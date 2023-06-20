package com.bcit.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

const val BREED1 = "com.bcit.lab3.1"
const val BREED2 = "com.bcit.lab3.2"
const val BREED3 = "com.bcit.lab3.3"

val dog_breed1 = Animal("german", R.drawable.german, "They are very smart")
val dog_breed2 = Animal("labrador", R.drawable.lab, "They are very fluffy")
val dog_breed3 = Animal("Rott", R.drawable.rott, "They are strong")

val cat_breed1 = Animal("Bengal", R.drawable.bengal, "They are from india")
val cat_breed2 = Animal("Persian", R.drawable.persian, "They are from persia")
val cat_breed3 = Animal("siamese", R.drawable.siamese, "They are from somewhere")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "animals by sahil rai"
    }

    fun to_breed_activity(view : View){
        val intent = Intent(this, breed_activity::class.java)

        intent.putExtra(BREED1, dog_breed1)
        intent.putExtra(BREED2, dog_breed2)
        intent.putExtra(BREED3, dog_breed3)


        startActivity(intent)
    }

    fun to_breed_cat(view : View){
        val intent = Intent(this, breed_activity::class.java)

        intent.putExtra(BREED1, cat_breed1)
        intent.putExtra(BREED2, cat_breed2)
        intent.putExtra(BREED3, cat_breed3)

        startActivity(intent)
    }
}