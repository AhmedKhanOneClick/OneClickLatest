package com.gama.task.ui.fragments.giftcards.ebayfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_gift_card_ebay.*

class EbayFragment : Fragment(R.layout.fragment_gift_card_ebay),EbayAdapter.OnItemClickListener {
    val ebayList=ArrayList<EbayData>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        ebayList.add(EbayData("2GB Per Month", "50".toInt(), "100","Ebay Recharg Card 50 SAR"))
        ebayList.add(EbayData("5GB Per Month", "100".toInt(), "200","Ebay Recharg Card 100 SAR"))
        ebayList.add(EbayData("10GB Per Month", "150".toInt(), "300","Ebay Recharg Card 150 SAR"))
        ebayList.add(EbayData("15GB Per Month", "200".toInt(), "400","Ebay Recharg Card 200 SAR"))
        ebayList.add(EbayData("20GB Per Month", "250".toInt(), "500","Ebay Recharg Card 250 SAR"))
        ebayList.add(EbayData("25GB Per Month", "300".toInt(), "600","Ebay Recharg Card 300 SAR"))
        ebayList.add(EbayData("30GB Per Month", "350".toInt(), "700","Ebay Recharg Card 350 SAR"))
        ebayList.add(EbayData("40GB Per Month", "400".toInt(), "800","Ebay Recharg Card 400 SAR"))
        ebay_rv.adapter = EbayAdapter(ebayList,this)
        ebay_rv.layoutManager = GridLayoutManager(context,2)
        ebay_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.ebay
                ,ebayList.get(position).text2
                ,ebayList.get(position).text3
                ,ebayList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(EbayFragmentDirections.actionEbayFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}