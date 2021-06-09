package com.gama.task.ui.fragments.reports

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.gama.task.data.repository.GeneralListsRepository
import com.gama.task.models.InsertAccounts
import com.gama.task.util.Event

/**
 * perform business logic and store ui states for [NewAccountFragment].
 */
class ReportsViewModel @ViewModelInject constructor(
    private val generalListsRepository: GeneralListsRepository
) : ViewModel() {

    /**
     * type, default is [Male]
     */



    val accountname = MutableLiveData("")

    val accountbalance = MutableLiveData("")


    private val _navigate = MutableLiveData<Event<Unit>>()

    /**
     * Immutable version of [_navigateToMainActivity]
     */
    val navigate = _navigate as LiveData<Event<Unit>>
    /**
     * Make api request to add the account  and return the response.
     */

    fun createInsertAccount() =InsertAccounts(
        accounts=Accounts_insert()
    )
    fun Accounts_insert()=InsertAccounts.Accounts1(
        id="",
        name =accountname.value!!,
        type = "checking",
        on_budget=false,
        closed=false,
        note = "",
        balance = Integer.parseInt(accountbalance.value!!),
        cleared_balance = 0,
        uncleared_balance = 0,
    transfer_payee_id="",
        deleted = false



    )
    /**
     * the id of order to get its details
     */
//    private val orderId = MutableLiveData<String>()
//    fun updateDetailsRequest(
//        id: String
//    ) {
//        if (orderId.value != id)
//            orderId.value = id
//        Log.d("initHotelsAndTra", "initHotelsAndTransportation9: ")
//    }
//    val details = orderId.switchMap { generalListsRepository.getAllDetails(it) }

}