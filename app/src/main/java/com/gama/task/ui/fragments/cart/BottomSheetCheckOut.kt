package com.gama.task.ui.fragments.cart

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import com.gama.task.ui.main.MainActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_botom_sheet_cart.*

class BottomSheetCheckOut: BottomSheetDialogFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).observeCartCounter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_botom_sheet_cart, container, false)


        check_out_btn.setOnClickListener {
            //- findNavController().navigate(BottomSheetCheckOutDirections.actionBottomSheetCheckOutToCartFragment())

        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        check_out_btn.text="Checkout ( "+GlobalClass.globalCartList.size.toString()+" )"
        check_out_btn.setOnClickListener {
            //handle click event
        //-    findNavController().navigate(BottomSheetCheckOutDirections.actionBottomSheetCheckOutToCartFragment())

          //  var activity :MainActivity
            //activity.cart_counter.setText("sdf")
            //cart_counter.text="4"


        }


    }


}