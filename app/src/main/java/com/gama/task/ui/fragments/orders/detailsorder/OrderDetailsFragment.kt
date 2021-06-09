package com.gama.task.ui.fragments.orders.detailsorder

import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.gama.task.ui.base.BaseFragment
import com.gama.task.R
import com.gama.task.databinding.TransactionIdBinding


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
            binding.requests1 = it.data.data.content


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