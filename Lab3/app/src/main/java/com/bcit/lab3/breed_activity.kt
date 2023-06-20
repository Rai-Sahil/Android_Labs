package com.bcit.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

const val TEXTFACT = "com.bcit.lab3.textfact"
const val IMAGE = "com.bcit.lab3.image"

class breed_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed)

        val breed_button_1  = findViewById<Button>(R.id.breed_button_1)
        val breed_button_2 = findViewById<Button>(R.id.breed_button_2)
        val breed_button_3 = findViewById<Button>(R.id.breed_button_3)

        val animal_breed1 = intent.getParcelableExtra<Animal>(BREED1)
        val animal_breed2 = intent.getParcelableExtra<Animal>(BREED2)
        val animal_breed3 = intent.getParcelableExtra<Animal>(BREED3)

        if (animal_breed1 != null) {
            breed_button_1.text = animal_breed1.breed
        }

        if (animal_breed2 != null) {
            breed_button_2.text = animal_breed2.breed
        }

        if (animal_breed3 != null) {
            breed_button_3.text = animal_breed3.breed
        }
    }

    fun fact_button(view: View){
        val animal_breed1 = intent.getParcelableExtra<Animal>(BREED1)
        val animal_breed2 = intent.getParcelableExtra<Animal>(BREED2)
        val animal_breed3 = intent.getParcelableExtra<Animal>(BREED3)

        val bundle = Bundle()

        val intent = Intent(this, fact_activity::class.java)
        if(view.id == R.id.breed_button_1){

            intent.putExtra(TEXTFACT, animal_breed1?.animalDescription)
            bundle.putSerializable(IMAGE, animal_breed1?.imageId)
            intent.putExtras(bundle)

        } else if(view.id == R.id.breed_button_2){

                intent.putExtra(TEXTFACT, animal_breed2?.animalDescription)
                bundle.putSerializable(IMAGE, animal_breed2?.imageId)
                intent.putExtras(bundle)

        } else {

                intent.putExtra(TEXTFACT, animal_breed3?.animalDescription)
                bundle.putSerializable(IMAGE, animal_breed3?.imageId)
                intent.putExtras(bundle)
        }


        startActivity(intent)
    }
}