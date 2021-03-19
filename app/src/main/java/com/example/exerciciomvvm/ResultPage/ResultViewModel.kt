package com.example.exerciciomvvm.ResultPage

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exerciciomvvm.Item
import com.example.exerciciomvvm.ItemRegistered

class ResultViewModel:ViewModel() {
    val item: MutableLiveData<List<Item>> by lazy { MutableLiveData<List<Item>>() }
    val result: MutableLiveData<Double> by lazy { MutableLiveData<Double>() }

    init {
        val itemRegister = ItemRegistered
        item.postValue(itemRegister.checkedItems)
        result()
    }

    private fun result(){
        val itemRegister = ItemRegistered
        var soma: Double = 0.0
        itemRegister.checkedItems.forEach {
            soma += it.value
        }
        result.postValue(soma)
    }
}
