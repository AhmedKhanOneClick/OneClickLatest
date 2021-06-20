package com.gama.task.ui.fragments.allreceipt

//- import com.gama.task.ui.fragments.cart.CartFragmentDirections
import CTOS.CtPrint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.gama.task.R
import kotlinx.android.synthetic.main.voucher_static_receipt.*
import java.text.SimpleDateFormat
import java.util.*


class VoucherReceiptFragment:Fragment(R.layout.voucher_static_receipt){

    lateinit var  btnPrint: Button
    lateinit var  viewPrint: View
    lateinit var  print: CtPrint

val args:VoucherReceiptFragmentArgs by navArgs()
    var imgId=""
    val simpleDateFormat= SimpleDateFormat("dd-MM-yyyy HH:MM:SS")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnPrint=view.findViewById(R.id.btnPrint)
        viewPrint=view.findViewById(R.id.view_print)
        print = CtPrint()
        imgId=args.imgId

        btnPrint.setOnClickListener {
            //doPrinting()
             }

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
    }
}