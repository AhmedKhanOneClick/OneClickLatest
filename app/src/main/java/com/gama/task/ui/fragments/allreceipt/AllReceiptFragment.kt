package com.gama.task.ui.fragments.allreceipt

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.CartAdapter
//-import com.gama.task.ui.fragments.cart.CartFragmentDirections
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_all_receipt.*
import kotlinx.android.synthetic.main.fragment_cart.*

class AllReceiptFragment:Fragment(R.layout.fragment_all_receipt),AllReceiptAdapter.OnItemClickListener {
    var checkout=0
    //var check_deleted=0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iterator = GlobalClass.globalCartList.listIterator()

        for (item in iterator) {

            checkout+=item.text2
        }
        all_receipt_rv.adapter = AllReceiptAdapter(GlobalClass.globalCartList,this)
        all_receipt_rv.layoutManager = LinearLayoutManager(context)
        all_receipt_rv.setHasFixedSize(true)
        //total.text=checkout.toString()
        final_receipt_btn.setOnClickListener {
         // -  findNavController().navigate(AllReceiptFragmentDirections.actionAllReceiptFragmentToFragmentReceipt())

        }
    }



    override fun onClick(position: Int) {


      //-  findNavController().navigate(AllReceiptFragmentDirections.actionAllReceiptFragmentToVoucherReceiptFragment())
    }


}