package com.gama.task.ui.fragments.giftcards.amazonfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cinemacards.kitaabsawti.KitaabsawtiAdapter
import com.gama.task.ui.fragments.cinemacards.kitaabsawti.KitaabsawtiData
import kotlinx.android.synthetic.main.fragment_cinema_card_kitaabsawti.*
import kotlinx.android.synthetic.main.fragment_gift_card_amazon.*
private const val TAG = "MyActivity"
class AmazonFragment: Fragment(R.layout.fragment_gift_card_amazon) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amazonList=ArrayList<AmazonData>()

        amazonList.add(AmazonData("2GB Per Month", "51", "100","XBox Recharg Card 50 SAR"))
        amazonList.add(AmazonData("5GB Per Month", "100", "200","XBox Recharg Card 100 SAR"))
        amazonList.add(AmazonData("10GB Per Month", "150", "300","XBox Recharg Card 150 SAR"))
        amazonList.add(AmazonData("15GB Per Month", "200", "400","XBox Recharg Card 200 SAR"))
        amazonList.add(AmazonData("20GB Per Month", "250", "500","XBox Recharg Card 250 SAR"))
        amazonList.add(AmazonData("25GB Per Month", "300", "600","XBox Recharg Card 300 SAR"))
        amazonList.add(AmazonData("30GB Per Month", "350", "700","XBox Recharg Card 350 SAR"))
        amazonList.add(AmazonData("40GB Per Month", "400", "800","XBox Recharg Card 400 SAR"))

        amazon_rv.adapter = AmazonAdapter(amazonList)
        amazon_rv.layoutManager = GridLayoutManager(context,2)
        amazon_rv.setHasFixedSize(true)
    }
}