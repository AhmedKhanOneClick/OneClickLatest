package com.gama.task.ui.fragments.orders

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.gama.saudi2go.data.db.UserAuthDao
import com.gama.task.data.repository.AuthRepository
import com.gama.task.data.repository.GeneralListsRepository
import com.gama.task.models.*
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment.Companion.TAG

import com.gama.task.util.Event

/**
 * perform business logic and store ui states for [AccountListFragment].
 */
class OrdersDataViewModel @ViewModelInject constructor(
    private val generalListsRepository: GeneralListsRepository
  , private val userAuthDao: UserAuthDao
) : ViewModel() {

    public val request_type = MutableLiveData<String>()

    private val _departments = MutableLiveData<Order>()
    val departments = _departments as LiveData<Order>

    fun updateRequest(id: String) {
        if (request_type.value != id)
            request_type.value = id
        Log.d("initHotelsAndTra", "initHotelsAndTransportation91: ")

    }


    /**
     * The list of Accounts in the current page.
     */
    private val _accountsList = MutableLiveData<MutableList<Content6>?>(ArrayList())

    /**
     * Immutable version of [_accountList].
     */
    val accountsList = _accountsList as LiveData<MutableList<Content6>>


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
    val allcontacts=request_type.switchMap {generalListsRepository.getAllOrdersdata(request_type.value!!.toString())}.apply {
        observeForever {

            if (it.data != null) {
                Log.d("fetchContacts", "fetchContacts: "+it.data.data)

                _navigatewithresult.postValue("")
                _accountsList.value =
                    _accountsList.value!!.apply { addAll(it.data.data.content) }
            }
        }
    }


    fun accept_statues1()=

        generalListsRepository.createOrder(departments.value!!)
            .apply {
                observeForever {
                    if(it.status==Status.SUCCESS){
                        Log.d(TAG, "accept_statues: "+it)
                    }else{
                        Log.d(TAG, "accept_statues: error"+it.message+" "+it.status+" "+it.code+" "+it.message)
                    }

                }
            }


    fun addDepts(depts:Order){
        _departments.value=depts

    }
    fun getvendorid():String= userAuthDao.getUserId().toString()
}