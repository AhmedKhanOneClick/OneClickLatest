package com.gama.task.ui.fragments.allreceipt

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.gama.task.R
import com.gama.task.ui.fragments.cart.CartAdapter
//- import com.gama.task.ui.fragments.cart.CartFragmentDirections
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_all_receipt.*
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.voucher_static_receipt.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class VoucherReceiptFragment:Fragment(R.layout.voucher_static_receipt){

val args:VoucherReceiptFragmentArgs by navArgs()
    var imgId=""
    val simpleDateFormat= SimpleDateFormat("dd-MM-yyyy HH:MM:SS")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        imgId=args.imgId

        val url="http://143.198.117.2:8080/api/files/"+imgId
        Glide
            .with(this)
            .load(url)
            .centerCrop()
            .into(card_ligo);
        var currentDT: String = simpleDateFormat.format(Date())
       voucher_date.text=currentDT.substring(0,10).toString()
        voucher_time.text=currentDT.substring(11,16).toString()
    }


}