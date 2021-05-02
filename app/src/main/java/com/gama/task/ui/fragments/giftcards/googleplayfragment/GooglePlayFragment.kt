package com.gama.task.ui.fragments.giftcards.googleplayfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*
import kotlinx.android.synthetic.main.fragment_gift_card_googleplay.*

class GooglePlayFragment: Fragment (R.layout.fragment_gift_card_googleplay) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val googleplayList=ArrayList<GooglePlayData>()

        googleplayList.add(GooglePlayData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        googleplayList.add(GooglePlayData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        googleplayList.add(GooglePlayData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        googleplayList.add(GooglePlayData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        googleplayList.add(GooglePlayData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        googleplayList.add(GooglePlayData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        googleplayList.add(GooglePlayData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        googleplayList.add(GooglePlayData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        googleplay_rv.adapter = GooglePlayAdapter(googleplayList)
        googleplay_rv.layoutManager = GridLayoutManager(context,2)
        googleplay_rv.setHasFixedSize(true)

    }
}