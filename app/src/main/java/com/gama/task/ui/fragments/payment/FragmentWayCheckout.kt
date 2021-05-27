package com.gama.task.ui.fragments.payment

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_way_checkout.*
import java.util.*

class FragmentWayCheckout: Fragment(R.layout.fragment_way_checkout) {
    private lateinit var myReceiver:MyReceiver
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myReceiver = MyReceiver()
        val filter  = IntentFilter()
        filter.addAction("surepay.mada.RESULT")
        requireActivity().registerReceiver(myReceiver, filter)

        post_balance.setOnClickListener {

            findNavController().navigate(FragmentWayCheckoutDirections.actionFragmentWayCheckoutToFragmentpurchase1())
        }

        bank_card.setOnClickListener {
            Log.d("TAG", "onViewCreated: ")
            sendAmountToMadaApplication()
//            findNavController().navigate(FragmentWayCheckoutDirections.actionFragmentWayCheckoutToFragmentpurchase1())
        }
/*
        Handler().postDelayed({


            view?.post {
                findNavController().navigate(Fragmentpurchase1Directions.actionFragmentpurchase1ToFragmentpurchase2())
            }
        }, 1000) // 3000 is the delayed time in milliseconds.



 */

    }
    private fun sendAmountToMadaApplication() {
        if (!isMadaAppInstalled()){
            Log.d("TAG", "Mada App Not Installed ")
            Toast.makeText(context,"Mada App Not Installed", Toast.LENGTH_SHORT).show()
            return
        }
        if (!isMadaAppRunning()){
            Toast.makeText(context, "Mada App Not Running", Toast.LENGTH_SHORT).show()
            val launchIntent =
                requireActivity().  packageManager.getLaunchIntentForPackage("com.surepay.mada")
            launchIntent?.let { startActivity(it) }
            return

        }
        val array = arrayListOf(
            "10.02","12.05",
            "162.09","14426.20",
            "00.10","120.00",
            "00.01","5.00",
            "45.00","8.71",
            "525.00","12.01",
            "1002.01","12.01",
            "52.01","914.01",
            "9.01","12.01",
            "8451.01","23.01",
            "123.01","321.01",
            "10002.01","102.01"
        )
        val randomStr = array[Random().nextInt(array.size)]

        val intent = Intent("surepay.mada.PAY_AMOUNT")
        intent.putExtra("AMOUNT",randomStr)
        requireActivity(). sendBroadcast(intent);
    }

    private fun isMadaAppInstalled(): Boolean {
        val pm = requireActivity().packageManager
        return try {
            pm.getPackageInfo("com.surepay.mada", PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
    @Suppress("DEPRECATION")
    fun isMadaAppRunning(): Boolean {
        try {
            val manager =
                requireActivity().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            for (service in manager.getRunningServices(Int.MAX_VALUE)) {
                if ("com.surepay.mada.MadaIntegration.MadaIntegrationService" == service.service.className) return true
            }
        } catch (ex: Exception) {
        }
        return false
    }

    }