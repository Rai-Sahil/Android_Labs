package com.bcit.lab8_sahil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

lateinit var db : FirebaseFirestore

class MainActivity : AppCompatActivity(),  View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Firebase.firestore

        findViewById<Button>(R.id.button_main_add).setOnClickListener(this)

        findViewById<Button>(R.id.button_main_map).setOnClickListener{
            var intent = Intent(this, PeopleActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onClick(v: View?) {
        val editText: EditText = findViewById(R.id.editText_main)
        val person = hashMapOf(
            "name" to editText.text.toString(),
            "location" to ll.latitude.toString() + ", " + ll.longitude.toString()
        )

        db.collection("Lab8")
            .add(person)
            .addOnSuccessListener { documentReference ->
                Log.d("ADD PERSON", "Document added with ID : ${documentReference.id}")
            }
            .addOnFailureListener{ e ->
                Log.d("ADD PERSON", "error adding document", e)
            }
    }
}