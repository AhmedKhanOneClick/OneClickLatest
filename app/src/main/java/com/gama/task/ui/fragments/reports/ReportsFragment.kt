package com.gama.task.ui.fragments.reports

import android.os.Bundle
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gama.task.ui.base.BaseFragment
import com.gama.task.R
import com.gama.task.databinding.ReportsBinding
import com.gama.task.databinding.TransactionIdBinding
import com.gama.task.ui.fragments.sidemenu.ReportsFragmentDirections


import dagger.hilt.android.AndroidEntryPoint


/**
 * Display hotel search results in list and in map.
 */
@AndroidEntryPoint
class ReportsFragment :
    BaseFragment<ReportsViewModel, ReportsBinding>(ReportsViewModel::class.java) {


    /**
     * The arguments of the fragment.
     */
//    private val args by navArgs<OrderDetailsFragmentArgs>()

    override fun getLayoutRes() = R.layout.reports

    override fun init() {
//binding.transactionId.setText("Transaction ID / "+args.reqId)
        initCreate()
        initDetails()

    }




private fun initDetails(){
binding.linear2.setOnClickListener {
    findNavController().navigate(R.id.getorders)
}
    binding.linear1.setOnClickListener {
        findNavController().navigate(R.id.getorders)
    }
}

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding.linear2.setOnClickListener {
//            findNavController().navigate(ReportsFragmentDirections.actionReportsFragmentToFragmentTransactionsTables())
//        }
//        binding.linear1.setOnClickListener {
//            findNavController().navigate(ReportsFragmentDirections.actionReportsFragmentToFragmentOrderPrint())
//        }
//    }
    /**
     * Add Anew Contact.
     */
    private fun initCreate() {



//        binding.back.setOnClickListener {
//            findNavController().navigateUp()
//        }
    }


}