package com.gama.task.ui.fragments.voicedatacharg.mobilyfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel :ViewModel(){
    val message = MutableLiveData<String>()

    fun sendMessage(text: String) {
        message.value = text
    }
    val asc = MutableLiveData<String>()

    fun sendAsc(text: String) {
        asc.value = text
    }
    val desc = MutableLiveData<String>()

    fun sendDesc(text: String) {
        desc.value = text
    }
}