package com.gama.task.ui.fragments.giftcards.itunefragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*
import kotlinx.android.synthetic.main.fragment_gift_card_itunes.*

class ItuneFragment : Fragment(R.layout.fragment_gift_card_itunes) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val itunesList=ArrayList<ItuneData>()

        itunesList.add(ItuneData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        itunesList.add(ItuneData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        itunesList.add(ItuneData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        itunesList.add(ItuneData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        itunesList.add(ItuneData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        itunesList.add(ItuneData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        itunesList.add(ItuneData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        itunesList.add(ItuneData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        itunes_rv.adapter = ItuneAdapter(itunesList)
        itunes_rv.layoutManager = GridLayoutManager(context,2)
        itunes_rv.setHasFixedSize(true)

    }
}