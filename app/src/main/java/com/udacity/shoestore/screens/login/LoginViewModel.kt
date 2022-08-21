package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _eventNavigateToWelcomeScreen = MutableLiveData<String?>()
    val eventNavigateToWelcomeScreen:LiveData<String?> get() = _eventNavigateToWelcomeScreen

    fun onLoginClicked() {
        val emailVal = email.value
        val passwordVal = password.value
        if(emailVal.isNullOrEmpty() || passwordVal.isNullOrEmpty()) return
        _eventNavigateToWelcomeScreen.value = emailVal
    }

    fun onDoneNavigation() {
        _eventNavigateToWelcomeScreen.value = null
    }
}