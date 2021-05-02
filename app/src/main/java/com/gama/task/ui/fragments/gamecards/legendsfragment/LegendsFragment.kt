package com.gama.task.ui.fragments.gamecards.legendsfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.fragment_game_card_legends.*
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*

class LegendsFragment : Fragment(R.layout.fragment_game_card_legends) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val legendsList=ArrayList<LegendsData>()

        legendsList.add(LegendsData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        legendsList.add(LegendsData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        legendsList.add(LegendsData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        legendsList.add(LegendsData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        legendsList.add(LegendsData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        legendsList.add(LegendsData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        legendsList.add(LegendsData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        legendsList.add(LegendsData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        legends_rv.adapter = LegendsAdapter(legendsList)
        legends_rv.layoutManager = GridLayoutManager(context,2)
        legends_rv.setHasFixedSize(true)

    }
}