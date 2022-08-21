package com.udacity.shoestore.screens.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val showList:LiveData<List<Shoe>> get() = _shoeList

    private val localList = mutableListOf<Shoe>()

    fun onAddShowClicked(){
        val newShoe = Shoe("Snikers",41.0,"Adidan","Very good for long running")
        localList.add(newShoe)
        _shoeList.value = localList
    }
}