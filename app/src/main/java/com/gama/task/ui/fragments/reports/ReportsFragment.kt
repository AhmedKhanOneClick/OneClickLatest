package com.gama.task.ui.fragments.reports

import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gama.task.ui.base.BaseFragment
import com.gama.task.R
import com.gama.task.databinding.ReportsBinding
import com.gama.task.databinding.TransactionIdBinding


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
    findNavController().navigate(R.id.getreportsfragment)
}
}
    /**
     * Add Anew Contact.
     */
    private fun initCreate() {



//        binding.back.setOnClickListener {
//            findNavController().navigateUp()
//        }
    }


}