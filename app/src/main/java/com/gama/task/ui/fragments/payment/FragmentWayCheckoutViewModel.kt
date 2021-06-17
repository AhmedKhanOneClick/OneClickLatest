package com.gama.task.ui.fragments.payment

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.gama.saudi2go.data.db.UserAuthDao
import com.gama.task.data.repository.GeneralListsRepository
import com.gama.task.models.Order
import com.gama.task.models.Status
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment


import com.gama.task.util.Event

/**
 * perform business logic and store ui states for [AccountListFragment].
 */
class FragmentWayCheckoutViewModel @ViewModelInject constructor(
    private val generalListsRepository: GeneralListsRepository
,private val userAuthDao: UserAuthDao
) : ViewModel() {

    private val _departments = MutableLiveData<Order>()
    val departments = _departments as LiveData<Order>

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



    fun accept_statues1()=

        generalListsRepository.createOrder(departments.value!!)
            .apply {
                observeForever {
                    if(it.status== Status.SUCCESS){
                        Log.d(DepartmentFragment.TAG, "accept_statues: "+it)
                    }else{
                        Log.d(DepartmentFragment.TAG, "accept_statues: error"+it.message+" "+it.status+" "+it.code+" "+it.message)
                    }

                }
            }


    fun addDepts(depts: Order){
        _departments.value=depts

    }
    fun getvendorid():String= userAuthDao.getUserId().toString()


}