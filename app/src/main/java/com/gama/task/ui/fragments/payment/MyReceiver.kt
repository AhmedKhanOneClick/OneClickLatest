package com.gama.task.ui.fragments.payment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.gama.saudi2go.data.db.UserAuthDao
import com.gama.task.BaseApp
import com.gama.task.data.api.ApiService
import com.gama.task.data.repository.GeneralListsRepository
import com.gama.task.models.Order
import com.gama.task.models.Status
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.gson.Gson
import com.surepay.integratemada.MadaResponseModel


class MyReceiver (): BroadcastReceiver() {
    private lateinit var app:BaseApp
    lateinit var model: SharedViewModel
    private val _departments = MutableLiveData<Order>()
    val departments = _departments as LiveData<Order>
    private lateinit var userAuthDao: UserAuthDao
    lateinit var apiService: ApiService

//    private lateinit var generalListsRepository: GeneralListsRepository
    // private val viewModel: FragmentWayCheckoutViewModel by viewModels()
    @SuppressLint("RestrictedApi")
    override fun onReceive(context: Context, intent: Intent) {
app= BaseApp()
        userAuthDao= UserAuthDao()
//        apiService=ApiService()
//generalListsRepository=GeneralListsRepository(apiService,userAuthDao)
        val result = intent.extras!!.getString("RESULT")
        Log.e("RESULT", "==================> $result")
        val topic = Gson().fromJson(
            result,
            MadaResponseModel::class.java
        )
        if (topic != null) Toast.makeText(context, "--> " + topic.aMOUNT, Toast.LENGTH_SHORT).show()
        Log.e("RESULT1", "==================> " + topic!!.aMOUNT)


//        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
//        model.sendSpecified_balance1(topic.aMOUNT)
        val products12= Order.Products11("0a94af0a3bed4f1dae06738b2629af01",1.0)
        val depts = Order(678904234.0,58.0, 58.0,2.0,3.0,11.0,"shipped",getvendorid(),
            listOf(products12)
        )
//        addDepts(depts)
//      accept_statues1()
    }

    fun addDepts(depts: Order){
        _departments.value=depts

    }
    fun getvendorid():String= userAuthDao.getUserId().toString()

//    fun accept_statues1()=
//
//        generalListsRepository.createOrder(departments.value!!)
//            .apply {
//                observeForever {
//                    if(it.status== Status.SUCCESS){
//                        Log.d(DepartmentFragment.TAG, "accept_statues: "+it)
//                    }else{
//                        Log.d(DepartmentFragment.TAG, "accept_statues: error"+it.message+" "+it.status+" "+it.code+" "+it.message)
//                    }
//
//                }
//            }



}