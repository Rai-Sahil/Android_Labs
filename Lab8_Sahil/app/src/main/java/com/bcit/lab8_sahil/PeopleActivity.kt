package com.bcit.lab8_sahil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class PeopleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)

        db = Firebase.firestore

        setup()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setup(){

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView_people)
        var resource = mutableListOf<Person>()

        db.collection("Lab8")
            .get()
            .addOnSuccessListener { result ->
                for (document in result){
                    Log.d("GET PERSON", "${document.id} => ${document.data}")

                    resource.add(document.toObject<Person>())
                }
                recyclerView.adapter = PersonAdapter(resource)
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
            .addOnFailureListener{ e ->
                Log.d("ADD PERSON", "error adding document", e)
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}