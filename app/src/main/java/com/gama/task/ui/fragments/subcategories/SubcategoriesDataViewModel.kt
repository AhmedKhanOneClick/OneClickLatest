package com.gama.task.ui.fragments.subcategories

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.gama.task.data.repository.GeneralListsRepository
import com.gama.task.models.*

import com.gama.task.util.Event

/**
 * perform business logic and store ui states for [AccountListFragment].
 */
class SubcategoriesDataViewModel @ViewModelInject constructor(
    private val generalListsRepository: GeneralListsRepository
) : ViewModel() {


    public val request_type = MutableLiveData<String>()
    public val language = MutableLiveData<String>()


    fun updateRequest(id: String,lng: String) {
        if (request_type.value != id) {
            request_type.value = id
        }
        if(language.value!=lng){
            language.value=lng
        }
        Log.d("initHotelsAndTra", "initHotelsAndTransportation91: ")

    }


    /**
     * The list of Accounts in the current page.
     */
    private val _accountsList = MutableLiveData<MutableList<Content2>?>(ArrayList())

    /**
     * Immutable version of [_accountList].
     */
    val accountsList = _accountsList as LiveData<MutableList<Content2>>


    //result of total of list
    private val _navigatewithresult = MutableLiveData<String>()

    /**
     * Immutable version of [_navigateToMainActivity]
     */
    val navigatewithresult = _navigatewithresult as LiveData<String>

    //return to page
    private val _returnwithsuccess = MutableLiveData<Event<Unit>>()

    /**
     * Immutable version of [_navigateToMainActivity]
     */
    val returnwithsuccess = _returnwithsuccess as LiveData<Event<Unit>>

    /**
     * The search request that has all search prams.
     */
    private val _filter = MutableLiveData<Filter>()

    /**
     * Immutable version of [_hotelSearchRequest].
     */
    val filter = _filter as LiveData<Filter>
    private val orderId = MutableLiveData<String>()
    fun updateDetailsRequest(
        id: String
    ) {
        if (orderId.value != id)
            orderId.value = id

    }

//Get All Accounts
    val allcontacts=request_type.switchMap {generalListsRepository.getAllSubCategoriesdata(request_type.value!!.toString())}.apply {
        observeForever {

            if (it.data != null) {
            Log.d("fetchContacts", "fetchContacts: "+it.data.data)

_navigatewithresult.postValue("")
                _accountsList.value =
                    _accountsList.value!!.apply { addAll(it.data.data.subcategories) }
        }
        }
    }




}