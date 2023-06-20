package com.bcit.lab8

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var db:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Firebase.firestore

        var button_main_add : Button = findViewById(R.id.button_main_add)
        button_main_add.setOnClickListener(this)

    }

    override fun onClick(view: View){
        val textEdit_main : EditText = findViewById(R.id.editText_main)
        val fragmentMap = MapsFragment()

        val person = hashMapOf(
            "name" to "sahil",
            "location" to "12, 3"
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