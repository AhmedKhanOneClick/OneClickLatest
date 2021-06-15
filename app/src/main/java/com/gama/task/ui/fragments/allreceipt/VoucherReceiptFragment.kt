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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class VoucherReceiptFragment:Fragment(R.layout.voucher_static_receipt){

val args:VoucherReceiptFragmentArgs by navArgs()
    var imgId=""
    @RequiresApi(Build.VERSION_CODES.O)
    val currentDateTime=LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        imgId=args.imgId

        val url="http://143.198.117.2:8080/api/files/"+imgId
        Glide
            .with(this)
            .load(url)
            .centerCrop()
            .into(card_ligo);

        voucher_date.text=currentDateTime.format(DateTimeFormatter.ISO_DATE)
        voucher_time.text=currentDateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
    }


}