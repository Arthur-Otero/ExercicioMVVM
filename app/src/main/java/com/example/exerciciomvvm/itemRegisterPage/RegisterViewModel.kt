package com.example.exerciciomvvm.itemRegisterPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel:ViewModel() {
    val nameValidate:MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val valueValidate:MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    fun validateFields(name: String,value: String){
        when{
            name.isBlank() && value.isBlank()->{
                nameValidate.postValue(false)
                valueValidate.postValue(false)
            }
            name.isBlank()->{
                nameValidate.postValue(false)
                valueValidate.postValue(true)
            }
            value.isBlank()->{
                nameValidate.postValue(true)
                valueValidate.postValue(false)
            }
            else->{
                nameValidate.postValue(true)
                valueValidate.postValue(true)
            }
        }
    }
}