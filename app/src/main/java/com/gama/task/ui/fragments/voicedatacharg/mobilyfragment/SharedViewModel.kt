package com.gama.task.ui.fragments.voicedatacharg.mobilyfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gama.task.data.repository.AuthRepository
import com.gama.task.models.Content
import com.gama.task.models.Products


class SharedViewModel() :ViewModel (){
    val message = MutableLiveData<String>()
    public val _accountsList = MutableLiveData<MutableList<Content>?>(ArrayList())
    public fun sendfavourites(content: Content) {
        if(_accountsList.value!!.contains(content)){
            _accountsList.value!!.remove(content)
            _accountsList.value=_accountsList.value
//            userrepositiry.deletefavourite(content)
        }else{
        _accountsList.value!!.add(content)
        _accountsList.value=_accountsList.value
//        userrepositiry.insertOrUpdatefAVOURITE(content)
        }
    }
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