package com.bcit.practice

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.model.Document
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Firebase.firestore

        val person = hashMapOf(
            "name" to "Tokyo"
        )


        db.collection("people")
            .add(person)
            .addOnSuccessListener { documentReference ->
                Log.d("ADD PERSON", "Document added with ID : ${documentReference.id}")
            }
            .addOnFailureListener{ e ->
                Log.d("ADD PERSON", "error adding document", e)
            }

        db.collection("people")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    Log.d("GET PERSON", "${document.id} => ${document.data}")
                }

            }
            .addOnFailureListener{ e ->
                Log.d("ADD PERSON", "error adding document", e)
            }

    }
}