package com.gama.task.ui.fragments.payment

import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import com.gama.task.models.Order
import com.gama.task.ui.fragments.cart.GlobalClass
import com.google.gson.Gson
import com.surepay.integratemada.MadaResponseModel
import kotlinx.android.synthetic.main.fragment_way_checkout.*
import java.util.*
import kotlin.collections.AbstractList


class FragmentWayCheckout: Fragment(R.layout.fragment_way_checkout) {
    private lateinit var myReceiver:MyReceiver
    private val viewModel: FragmentWayCheckoutViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        myReceiver = MyReceiver()
        val myReceiver1: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val result = intent.extras!!.getString("RESULT")
                Log.e("RESULT", "==================> $result")
                val topic = Gson().fromJson(
                    result,
                    MadaResponseModel::class.java
                )
                if (topic != null) Toast.makeText(context, "--> " + topic.aMOUNT, Toast.LENGTH_SHORT).show()
                Log.e("RESULT1", "==================> " + topic!!.aMOUNT)
                if (!topic.tX_RESPONSECODE.equals("1")){
                    createOrder()
                }
            }
        }
        val filter  = IntentFilter()
        filter.addAction("surepay.mada.RESULT")
        requireActivity().registerReceiver(myReceiver, filter)
        requireActivity().registerReceiver(myReceiver1, filter)

        post_balance.setOnClickListener {

           findNavController().navigate(FragmentWayCheckoutDirections.actionFragmentWayCheckoutToAllReceiptFragment())
        }

        bank_card.setOnClickListener {
            //findNavController().navigate(FragmentWayCheckoutDirections.actionFragmentWayCheckoutToFragmentpurchase1())
            Log.d("TAG", "onViewCreated: ")
            sendAmountToMadaApplication()
                        findNavController().navigate(FragmentWayCheckoutDirections.actionFragmentWayCheckoutToAllReceiptFragment())
        } }
    private fun sendAmountToMadaApplication() {
        if (!isMadaAppInstalled()){
            Log.d("TAG", "Mada App Not Installed ")
            Toast.makeText(context, "Mada App Not Installed", Toast.LENGTH_SHORT).show()
            return
        }
        if (!isMadaAppRunning()){
            Toast.makeText(context, "Mada App Not Running", Toast.LENGTH_SHORT).show()
            val launchIntent =
                requireActivity().  packageManager.getLaunchIntentForPackage("com.surepay.mada")
            launchIntent?.let { startActivity(it) }
            return

        }
        var array = ArrayList<String>()
        for(item in GlobalClass.globalCartList.indices){

            array.add(GlobalClass.globalCartList.get(item).Price.toString())

            Log.e("dynamic voucher price-",item.toString()+GlobalClass.globalCartList.get(item).Price.toString())
        }


        val randomStr = array[Random().nextInt(array.size)]

        val intent = Intent("surepay.mada.PAY_AMOUNT")
        intent.putExtra("AMOUNT", randomStr)
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

    fun  createOrder(){

        val products12= Order.Products11("0a94af0a3bed4f1dae06738b2629af01", 1.0)
        val depts = Order(
            678904234.0, 58.0, 58.0, 2.0, 3.0, 11.0, "shipped", viewModel.getvendorid(),
            listOf(products12)
        )
        viewModel.addDepts(depts)
        viewModel.accept_statues1()
    }

}