package com.gama.task.ui.fragments.giftcards.facebookfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_gift_card_facebook.*

class FacebookFragment : Fragment(R.layout.fragment_gift_card_facebook),FacebookAdapter.OnItemClickListener {
    val facebookList=ArrayList<FacebookData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        facebookList.add(FacebookData("2GB Per Month", "50".toInt(), "100","Facebook Recharg Card 50 SAR"))
        facebookList.add(FacebookData("5GB Per Month", "100".toInt(), "200","Facebook Recharg Card 100 SAR"))
        facebookList.add(FacebookData("10GB Per Month", "150".toInt(), "300","Facebook Recharg Card 150 SAR"))
        facebookList.add(FacebookData("15GB Per Month", "200".toInt(), "400","Facebook Recharg Card 200 SAR"))
        facebookList.add(FacebookData("20GB Per Month", "250".toInt(), "500","Facebook Recharg Card 250 SAR"))
        facebookList.add(FacebookData("25GB Per Month", "300".toInt(), "600","Facebook Recharg Card 300 SAR"))
        facebookList.add(FacebookData("30GB Per Month", "350".toInt(), "700","Facebook Recharg Card 350 SAR"))
        facebookList.add(FacebookData("40GB Per Month", "400".toInt(), "800","Facebook Recharg Card 400 SAR"))
        facebook_rv.adapter = FacebookAdapter(facebookList,this)
        facebook_rv.layoutManager = GridLayoutManager(context,2)
        facebook_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.facebook
                ,facebookList.get(position).text2
                ,facebookList.get(position).text3
                ,facebookList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(FacebookFragmentDirections.actionFacebookFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}