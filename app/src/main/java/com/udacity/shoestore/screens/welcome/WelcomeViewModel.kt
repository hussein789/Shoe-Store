package com.udacity.shoestore.screens.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _eventNavigateToInstruction = MutableLiveData<Boolean>()
    val eventNavigateToInstruction:LiveData<Boolean> get() = _eventNavigateToInstruction

    private val _email = MutableLiveData<String>()
    val email:LiveData<String> get() = _email

    fun onNavigateClicked(){
        _eventNavigateToInstruction.value = true
    }

    fun onDoneNavigation(){
        _eventNavigateToInstruction.value = false
    }

    fun init(emailField: String) {
        _email.value = emailField
    }
}