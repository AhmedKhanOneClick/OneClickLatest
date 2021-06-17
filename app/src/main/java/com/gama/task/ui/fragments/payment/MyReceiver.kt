package com.gama.task.ui.fragments.payment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gama.saudi2go.data.db.UserAuthDao
import com.gama.task.data.api.ApiService
import com.gama.task.data.repository.GeneralListsRepository
import com.gama.task.data.repository.NetworkOnlyResource
import com.gama.task.models.GeneralResponse
import com.gama.task.models.Order
import com.gama.task.models.Status
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment
import com.google.gson.Gson
import com.surepay.integratemada.MadaResponseModel


class MyReceiver (): BroadcastReceiver() {


    // private val viewModel: FragmentWayCheckoutViewModel by viewModels()
    override fun onReceive(context: Context, intent: Intent) {



        val result = intent.extras!!.getString("RESULT")
        Log.e("RESULT", "==================> $result")
        val topic = Gson().fromJson(
            result,
            MadaResponseModel::class.java
        )
        if (topic != null) Toast.makeText(context, "--> " + topic.aMOUNT, Toast.LENGTH_SHORT).show()
        Log.e("RESULT1", "==================> " + topic!!.aMOUNT)

    }






}