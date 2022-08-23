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

    val shoeName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()

    private val localList = mutableListOf<Shoe>()

    fun onSaveShoeClicked() {
        val name = shoeName.value?.toString() ?: ""
        val description = shoeDescription.value?.toString() ?: ""
        val company = shoeCompany.value?.toString() ?: ""
        val size = shoeSize.value?.toString() ?: ""
        if(name.isEmpty() || description.isEmpty() || company.isEmpty() || size.isEmpty()) return
        val newShoe = Shoe(name,size.toDouble(),company,description)
        localList.add(newShoe)
        _shoeList.value = localList
        _eventNavigateToShowList.value = true
    }

    fun onCancelClicked() {
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

    fun clearFields(){
        shoeName.value = ""
        shoeSize.value = ""
        shoeCompany.value = ""
        shoeDescription.value = ""
    }
}