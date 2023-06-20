package com.bcit.kotlinflow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    // This is live data
    val currentUser:MutableLiveData<User> = MutableLiveData<User>()
    val allUsers:MutableLiveData<List<User>> = MutableLiveData<List<User>>()

    //Stream
    val mainRepository:MainRepository = MainRepository()

    init {
        observeUsers()
    }

    fun observeUsers(){
        val scope = CoroutineScope(Dispatchers.Main)

        scope.launch {
            mainRepository.getUserFlow().collect{
                allUsers.value = it
            }
        }
    }
}