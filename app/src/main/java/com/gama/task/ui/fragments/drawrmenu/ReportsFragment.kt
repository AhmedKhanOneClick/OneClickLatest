package com.gama.task.ui.fragments.drawrmenu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_menu_reports.*

class ReportsFragment:Fragment(R.layout.fragment_menu_reports) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        device_order_print.setOnClickListener {

            findNavController().navigate(ReportsFragmentDirections.actionReportsFragmentToFragmentOrderPrint())
        }

        transaction_statement.setOnClickListener {

            findNavController().navigate(ReportsFragmentDirections.actionReportsFragmentToFragmentTransactionsTables())
        }

    }
}