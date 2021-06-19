package com.gama.task.ui.fragments.payment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel :ViewModel(){

    //balance
    val specifiedbalance1 = MutableLiveData<String>()
    fun sendSpecified_balance1 (text: String) {
        specifiedbalance1 .value = text
    }

}