package com.example.exerciciomvvm.mainPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exerciciomvvm.Item
import com.example.exerciciomvvm.ItemRegistered

class MainViewModel:ViewModel() {
    val item: MutableLiveData<List<Item>> by lazy { MutableLiveData<List<Item>>() }
    val itemChecked: MutableLiveData<List<Item>> by lazy { MutableLiveData<List<Item>>() }

    init {
        val itemRegistered = ItemRegistered
        item.postValue(itemRegistered.items)
    }

    fun isChecked(checked:List<Item>){
        val listChecked = mutableListOf<Item>()
        checked.forEach {
            if (it.checked)
                listChecked.add(it)
        }
        itemChecked.postValue(listChecked)
    }
}