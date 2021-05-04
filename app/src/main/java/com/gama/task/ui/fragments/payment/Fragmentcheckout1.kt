package com.gama.task.ui.fragments.payment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_confirm_checkout.*

class Fragmentcheckout1: Fragment(R.layout.fragment_confirm_checkout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       add_more_cards.setOnClickListener {

findNavController().navigate(Fragmentcheckout1Directions.actionFragmentcheckout1ToSearchPagerFragment())

       }
        confirmcheckout.setOnClickListener {
findNavController().navigate(Fragmentcheckout1Directions.actionFragmentcheckout1ToFragmentWayCheckout())
        }



    }
}