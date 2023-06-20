package com.bcit.async

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {

    var currentUser:MutableLiveData<User> = MutableLiveData()

}