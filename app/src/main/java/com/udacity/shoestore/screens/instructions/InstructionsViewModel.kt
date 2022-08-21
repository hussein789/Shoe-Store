package com.udacity.shoestore.screens.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel : ViewModel() {

    private val _eventNavigateToShowList = MutableLiveData<Boolean>()
    val eventNavigateToShowList:LiveData<Boolean> get() = _eventNavigateToShowList

    fun onShowListClicked(){
        _eventNavigateToShowList.value = true
    }

    fun onDoneNavigation(){
        _eventNavigateToShowList.value = false
    }
}