package com.bcit.async

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

interface GenericCallbackData{
    var value:Int?
}

class InfoViewModel: ViewModel() {
    var genericLiveData:MutableLiveData<Int> = MutableLiveData()

    //Creating our callback data
    lateinit var genericCallbackData:GenericCallbackData
}