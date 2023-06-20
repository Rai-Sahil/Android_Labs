package com.bcit.kotlinflow

import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainRepository {

    var db = Firebase.firestore

    fun getUserFlow(): Flow<List<User>> {
        return db.collection("User")
            .snapshots().map {
                value: QuerySnapshot -> value.toObjects()
            }
    }

}