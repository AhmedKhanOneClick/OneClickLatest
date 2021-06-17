package com.gama.task.ui.fragments.orders.detailsorder

import android.util.Log
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.gama.task.ui.base.BaseFragment
import com.gama.task.R
import com.gama.task.databinding.TransactionIdBinding
import com.gama.task.ui.Home.AdvancedSearch.Departments.DepartmentFragment.Companion.TAG


import dagger.hilt.android.AndroidEntryPoint


/**
 * Display hotel search results in list and in map.
 */
@AndroidEntryPoint
class OrderDetailsFragment :
    BaseFragment<OrderDetailsViewModel, TransactionIdBinding>(OrderDetailsViewModel::class.java) {


    /**
     * The arguments of the fragment.
     */
    private val args by navArgs<OrderDetailsFragmentArgs>()

    override fun getLayoutRes() = R.layout.transaction_id

    override fun init() {
//binding.transactionId.setText("Transaction ID / "+args.reqId)
        initCreate()
        initDetails()

    }




private fun initDetails(){

    viewModel.updateDetailsRequest(args.reqId)
    binding.transactionId.setText("Transaction ID / "+args.reqId)
    viewModel.details.observe(viewLifecycleOwner, ::handleApiStatus)

    viewModel.details.observe(viewLifecycleOwner) {
        if (it.data != null) {
            Log.d(TAG, "initDetails:999993 "+it.toString())
            Log.d(TAG, "initDetails:99999 "+it.data.data)
            binding.requests1 = it.data.data


//            binding.step.setImageDrawable(resources.getDrawable(R.drawable.image1_7))

        }
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