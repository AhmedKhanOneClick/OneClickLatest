package com.gama.task.ui.fragments.giftcards.googleplayfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*
import kotlinx.android.synthetic.main.fragment_gift_card_googleplay.*

class GooglePlayFragment: Fragment (R.layout.fragment_gift_card_googleplay),GooglePlayAdapter.OnItemClickListener {

    val googleplayList=ArrayList<GooglePlayData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        googleplayList.add(GooglePlayData("2GB Per Month", "50".toInt(), "100","Google Recharg Card 50 SAR"))
        googleplayList.add(GooglePlayData("5GB Per Month", "100".toInt(), "200","Google Recharg Card 100 SAR"))
        googleplayList.add(GooglePlayData("10GB Per Month", "150".toInt(), "300","Google Recharg Card 150 SAR"))
        googleplayList.add(GooglePlayData("15GB Per Month", "200".toInt(), "400","Google Recharg Card 200 SAR"))
        googleplayList.add(GooglePlayData("20GB Per Month", "250".toInt(), "500","Google Recharg Card 250 SAR"))
        googleplayList.add(GooglePlayData("25GB Per Month", "300".toInt(), "600","Google Recharg Card 300 SAR"))
        googleplayList.add(GooglePlayData("30GB Per Month", "350".toInt(), "700","Google Recharg Card 350 SAR"))
        googleplayList.add(GooglePlayData("40GB Per Month", "400".toInt(), "800","Google Recharg Card 400 SAR"))
        googleplay_rv.adapter = GooglePlayAdapter(googleplayList,this)
        googleplay_rv.layoutManager = GridLayoutManager(context,2)
        googleplay_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.vip_jalsaat
                ,googleplayList.get(position).text2
                ,googleplayList.get(position).text3
                ,googleplayList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(GooglePlayFragmentDirections.actionGoogleplayFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}