package com.gama.task.ui.fragments.giftcards.facebookfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_gift_card_facebook.*

class FacebookFragment : Fragment(R.layout.fragment_gift_card_facebook) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val facebookList=ArrayList<FacebookData>()

        facebookList.add(FacebookData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        facebookList.add(FacebookData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        facebookList.add(FacebookData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        facebookList.add(FacebookData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        facebookList.add(FacebookData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        facebookList.add(FacebookData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        facebookList.add(FacebookData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        facebookList.add(FacebookData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        facebook_rv.adapter = FacebookAdapter(facebookList)
        facebook_rv.layoutManager = GridLayoutManager(context,2)
        facebook_rv.setHasFixedSize(true)

    }
}