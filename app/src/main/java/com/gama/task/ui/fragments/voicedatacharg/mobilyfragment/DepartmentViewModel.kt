package com.gama.task.ui.Home.AdvancedSearch.Departments

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.gama.task.data.repository.GeneralListsRepository

import com.gama.task.util.Event

/**
 * perform business logic and store ui states for [LoginFragment].
 */
class DepartmentViewModel @ViewModelInject constructor(private val generalListsRepository: GeneralListsRepository) :
    ViewModel() {

    /**
     * Pair of entered email and password entered by user.
     */
    private val userInfo: MutableLiveData<Pair<String, String>> = MutableLiveData()


    /**
     *  event to navigate to the main activity after the login completed successfully and stored.
     */
    private val _navigateToMainActivity = MutableLiveData<Event<Unit>>()

    /**
     * Immutable version of [_navigateToMainActivity]
     */
    val navigateToMainActivity = _navigateToMainActivity as LiveData<Event<Unit>>



    private val _navigate = MutableLiveData<Event<Unit>>()

    /**
     * Immutable version of [_navigateToMainActivity]
     */
    val navigate = _navigate as LiveData<Event<Unit>>

    /**
     *  event to display error.
     */
    private val _error = MutableLiveData<Event<Unit>>()

    /**
     * Immutable version of [_navigateToMainActivity]
     */
    val error = _error as LiveData<Event<Unit>>



    private val orderId = MutableLiveData<String>()
    fun updateDetailsRequest(
        id: String
    ) {
        if (orderId.value != id)
            orderId.value = id
        Log.d("initHotelsAndTra", "initHotelsAndTransportation9: ")
    }

//    fun accept_statues()= orderId.switchMap {generalListsRepository.getAllApproveandDenyStatues(it,"approve")}.apply {

//    }




}