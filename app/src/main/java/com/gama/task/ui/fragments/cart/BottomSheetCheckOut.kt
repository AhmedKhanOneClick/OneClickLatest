package com.gama.task.ui.fragments.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_botom_sheet_cart.*
import java.util.zip.Inflater

class BottomSheetCheckOut: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_botom_sheet_cart, container, false)

        check_out_btn.setOnClickListener {
            findNavController().navigate(BottomSheetCheckOutDirections.actionBottomSheetCheckOutToCartFragment())

        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        check_out_btn.text="Check Out ( "+GlobalClass.globalCartList.size.toString()+" )"
        check_out_btn.setOnClickListener {
            //handle click event
           findNavController().navigate(BottomSheetCheckOutDirections.actionBottomSheetCheckOutToCartFragment())

        }


    }


}