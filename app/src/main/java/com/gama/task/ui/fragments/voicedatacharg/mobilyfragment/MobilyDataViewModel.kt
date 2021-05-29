package com.gama.task.ui.fragments.voicedatacharg.mobilyfragment

import android.preference.PreferenceManager
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.gama.task.data.repository.GeneralListsRepository
import com.gama.task.models.Content
import com.gama.task.models.MobileData1

import com.gama.task.models.Filter

import com.gama.task.util.Event
import com.google.gson.Gson

/**
 * perform business logic and store ui states for [AccountListFragment].
 */
class MobilyDataViewModel @ViewModelInject constructor(
    private val generalListsRepository: GeneralListsRepository
) : ViewModel() {





    /**
//     * The list of Accounts in the current page.
//     */
    private val _accountsList = MutableLiveData<MutableList<Content>?>(ArrayList())

    /**
     * Immutable version of [_accountList].
     */
    val accountsList = _accountsList as LiveData<MutableList<Content>>


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
    val allcontacts=generalListsRepository.getAllProducts().apply {
        observeForever {

            if (it.data != null) {
            Log.d("fetchContacts", "fetchContacts: "+it.data.data)

_navigatewithresult.postValue("")
                _accountsList.value =
                    _accountsList.value!!.apply { addAll(it.data.data.content) }
        }
        }
    }
fun addfavouriterealm(content:Content){


}

    public val _accountsList1 = MutableLiveData<MutableList<Content>?>(ArrayList())
    public fun sendfavourites(content: Content) {
//        if(generalListsRepository.getAllFavourites().contains(content)){
////            _accountsList1.value!!.remove(content)
////            _accountsList1.value=_accountsList.value
//            generalListsRepository.deletefavourite(content)
//        }else{
//            _accountsList1.value!!.add(content)
//            _accountsList1.value=_accountsList.value
            generalListsRepository.insertOrUpdatefAVOURITE(content)
//        favouritedao.insertFavourite(content)


//        }
    }

}