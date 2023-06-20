package com.bcit.lab3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Animal(var animalBreed:String? =null, var imageId: Int? = null, var animalDescription: String? = null) :
    Parcelable {
    var breed: String? = null
    var resourcesId: Int? = null
    var description: String? = null

    init {
        breed = animalBreed
        resourcesId = imageId
        description = animalDescription
    }

}