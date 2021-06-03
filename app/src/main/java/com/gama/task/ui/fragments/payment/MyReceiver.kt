package com.gama.task.ui.fragments.payment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.surepay.integratemada.MadaResponseModel

class MyReceiver : BroadcastReceiver() {
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