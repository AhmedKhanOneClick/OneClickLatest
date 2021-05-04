package com.gama.task.ui.fragments.payment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_way_checkout.*

class FragmentWayCheckout: Fragment(R.layout.fragment_way_checkout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        post_balance.setOnClickListener {

            findNavController().navigate(FragmentWayCheckoutDirections.actionFragmentWayCheckoutToFragmentpurchase1())
        }

        bank_card.setOnClickListener {
            findNavController().navigate(FragmentWayCheckoutDirections.actionFragmentWayCheckoutToFragmentpurchase1())
        }
/*
        Handler().postDelayed({


            view?.post {
                findNavController().navigate(Fragmentpurchase1Directions.actionFragmentpurchase1ToFragmentpurchase2())
            }
        }, 1000) // 3000 is the delayed time in milliseconds.



 */

    }

}