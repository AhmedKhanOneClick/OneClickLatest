package com.gama.task.ui.fragments.giftcards.ebayfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_gift_card_ebay.*

class EbayFragment : Fragment(R.layout.fragment_gift_card_ebay) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val ebayList=ArrayList<EbayData>()

        ebayList.add(EbayData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        ebayList.add(EbayData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        ebayList.add(EbayData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        ebayList.add(EbayData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        ebayList.add(EbayData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        ebayList.add(EbayData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        ebayList.add(EbayData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        ebayList.add(EbayData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        ebay_rv.adapter = EbayAdapter(ebayList)
        ebay_rv.layoutManager = GridLayoutManager(context,2)
        ebay_rv.setHasFixedSize(true)

    }
}