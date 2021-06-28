package com.gama.task.ui.fragments.allreceipt

//- import com.gama.task.ui.fragments.cart.CartFragmentDirections

import CTOS.CtPrint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.main.MainActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.voucher_receipt_layout.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


//class VoucherReceiptFragment:Fragment(R.layout.voucher_static_receipt){
class VoucherReceiptFragment:Fragment(R.layout.voucher_receipt_layout){

    lateinit var  viewPrint: View

    lateinit var  print: CtPrint
    var position=0
    var price=""
val args:VoucherReceiptFragmentArgs by navArgs()
    var imgId=""
    val simpleDateFormat= SimpleDateFormat("dd-MM-yyyy HH:MM:SS")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        position = args.position
        viewPrint = view.findViewById(R.id.view_print)
        print = CtPrint()
        imgId = args.imgId
        val url = "http://143.198.117.2:8080/api/files/" + imgId

        price = ((GlobalClass.globalCartList.get(position).Price) * (GlobalClass.globalCartList.get(
            position
        ).quanty)).toString()

        card_price.text = price + " SAR"
//        card_price2.text = price + " SAR"
        //doPrinting()
       

        Picasso.get().load(url)
            .into(card_ligo, object : Callback {
                override fun onSuccess() {
                    Toast.makeText(context, "printing now please wait", Toast.LENGTH_SHORT).show()
                    doPrinting()
                }

                override fun onError(e: Exception?) {

                }


            })
////
//        Glide
//            .with(this)
//            .load(url)
//            .centerCrop()
//            .into(card_ligo);


        var currentDT: String = simpleDateFormat.format(Date())
        voucher_date.text = currentDT.substring(0, 10).toString()
        voucher_time.text = currentDT.substring(11, 16).toString()


       // btnPrint.setOnClickListener {  doPrinting() }
    }


    fun getBitmapFromView(view: View): Bitmap {
        view.measure(
            View.MeasureSpec.UNSPECIFIED,
            View.MeasureSpec.UNSPECIFIED
        )
        val bitmap = Bitmap.createBitmap(
            view.measuredWidth, view.measuredHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.draw(canvas)
        return bitmap
    }

    private fun doPrinting() {
        val image4: Bitmap = getBitmapFromView(viewPrint!!)
        print!!.initPage(image4.height)
        print!!.drawImage(image4, 0, 0)
        print!!.printPage()
        print!!.roll(100)

        (GlobalClass.globalCartList.removeAt(position))
        (activity as MainActivity).observeCartCounter()
        if (GlobalClass.globalCartList.size==0){

            val action=VoucherReceiptFragmentDirections.actionVoucherReceiptFragmentToSearchPagerFragment()
            findNavController().navigate(action)
        }else{
            val action=VoucherReceiptFragmentDirections.actionVoucherReceiptFragmentToAllReceiptFragment()
            findNavController().navigate(action)
        }

    }
}