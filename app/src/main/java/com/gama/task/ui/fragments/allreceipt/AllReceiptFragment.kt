package com.gama.task.ui.fragments.allreceipt

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gama.task.R
//-import com.gama.task.ui.fragments.cart.CartFragmentDirections
import com.gama.task.ui.fragments.cart.GlobalClass
import kotlinx.android.synthetic.main.fragment_all_receipt.*
import kotlinx.android.synthetic.main.fragment_cart.*

class AllReceiptFragment:Fragment(R.layout.fragment_all_receipt),AllReceiptAdapter.OnItemClickListener {
    var checkout=0.00
    //var check_deleted=0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iterator = GlobalClass.globalCartList.listIterator()

        for (item in iterator) {

            checkout+=item.Price
        }
        all_receipt_rv.adapter = AllReceiptAdapter(this.requireContext(),GlobalClass.globalCartList,this)
        all_receipt_rv.layoutManager = LinearLayoutManager(context)
        all_receipt_rv.setHasFixedSize(true)
       total?.setText(checkout.toString())
        final_receipt_btn.setOnClickListener {
       findNavController().navigate(AllReceiptFragmentDirections.actionAllReceiptFragmentToFragmentReceipt())

        }
    }



    override fun onClick(position: Int) {

val action=AllReceiptFragmentDirections.actionAllReceiptFragmentToVoucherReceiptFragment()

        action.imgId=GlobalClass.globalCartList.get(position).img_id
        findNavController().navigate(action)
    }


}