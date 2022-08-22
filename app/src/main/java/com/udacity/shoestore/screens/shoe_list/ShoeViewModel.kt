package com.udacity.shoestore.screens.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val showList:LiveData<List<Shoe>> get() = _shoeList

    private val _eventNavigateToShowList = MutableLiveData<Boolean>()
    val eventNavigateToShowList:LiveData<Boolean> get() = _eventNavigateToShowList

    private val _eventNavigateToShoeDetails = MutableLiveData<Boolean>()
    val eventNavigateToShoeDetails:LiveData<Boolean> get() = _eventNavigateToShoeDetails

    private val localList = mutableListOf<Shoe>()

    fun onSaveShoeClicked(name:String, size:Double, description:String, company:String) {
        if(name.isEmpty() || description.isEmpty() || company.isEmpty()) return
        val newShoe = Shoe(name,size,company,description)
        localList.add(newShoe)
        _shoeList.value = localList
        _eventNavigateToShowList.value = true
    }

    fun onCancelClicked(){
        _eventNavigateToShowList.value = true
    }

    fun onAddShoeClicked(){
        _eventNavigateToShoeDetails.value = true
    }

    fun onDoneDetailsNavigation(){
        _eventNavigateToShoeDetails.value = false
    }

    fun onDoneListNavigation(){
        _eventNavigateToShowList.value = false
    }

    fun updateList() {
        _shoeList.value = localList
    }

    fun clearList() {
        localList.clear()
    }
}