package com.gama.task.ui.fragments.giftcards.amazonfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.cinemacards.kitaabsawti.KitaabsawtiAdapter
import com.gama.task.ui.fragments.cinemacards.kitaabsawti.KitaabsawtiData
import kotlinx.android.synthetic.main.fragment_cinema_card_kitaabsawti.*
import kotlinx.android.synthetic.main.fragment_gift_card_amazon.*
private const val TAG = "MyActivity"
class AmazonFragment: Fragment(R.layout.fragment_gift_card_amazon),AmazonAdapter.OnItemClickListener{
    val amazonList=ArrayList<AmazonData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        amazonList.add(AmazonData("2GB Per Month", "51".toInt(), "51","Amazon Recharg Card 50 SAR"))
        amazonList.add(AmazonData("5GB Per Month", "100".toInt(), "100","Amazon Recharg Card 100 SAR"))
        amazonList.add(AmazonData("10GB Per Month", "150".toInt(), "150","Amazon Recharg Card 150 SAR"))
        amazonList.add(AmazonData("15GB Per Month", "200".toInt(), "400","Amazon Recharg Card 200 SAR"))
        amazonList.add(AmazonData("20GB Per Month", "250".toInt(), "500","Amazon Recharg Card 250 SAR"))
        amazonList.add(AmazonData("25GB Per Month", "300".toInt(), "600","Amazon Recharg Card 300 SAR"))
        amazonList.add(AmazonData("30GB Per Month", "350".toInt(), "700","Amazon Recharg Card 350 SAR"))
        amazonList.add(AmazonData("40GB Per Month", "400".toInt(), "800","Amazon Recharg Card 400 SAR"))

        amazon_rv.adapter = AmazonAdapter(amazonList,this)
        amazon_rv.layoutManager = GridLayoutManager(context,2)
        amazon_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.amazon
                ,amazonList.get(position).text2
                ,amazonList.get(position).text3
                ,amazonList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(AmazonFragmentDirections.actionAmazonFragmentToBottomSheetCheckOut())

    }

    override fun onLongClick(position: Int) {

    }
}