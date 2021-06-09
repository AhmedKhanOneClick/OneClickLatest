package com.gama.task.ui.fragments.voicedatacharg.mobilyfragment

import android.preference.PreferenceManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gama.task.data.repository.AuthRepository
import com.gama.task.models.Content
import com.gama.task.models.Products
import com.google.gson.Gson


class SharedViewModel() :ViewModel (){
    val message = MutableLiveData<String>()
    public val _accountsList = MutableLiveData<MutableList<Content>?>(ArrayList())
    val _accountsList1 = MutableLiveData<MutableList<Content>?>(ArrayList())
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
    public fun sendfavourites2(){
        _accountsList1.value!!.clear()
    }
    public fun sendfavourites1(content: Content) {
//        if(_accountsList1.value!!.contains(content)){
//            _accountsList1.value!!.remove(content)
//            _accountsList1.value=_accountsList1.value
////            userrepositiry.deletefavourite(content)
//        }else{
            _accountsList1.value!!.add(content)
            _accountsList1.value=_accountsList1.value
//        userrepositiry.insertOrUpdatefAVOURITE(content)
//        }
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