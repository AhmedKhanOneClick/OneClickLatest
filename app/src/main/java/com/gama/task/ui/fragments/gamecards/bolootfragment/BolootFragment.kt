package com.gama.task.ui.fragments.gamecards.bolootfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_game_card_boloot.*


class BolootFragment : Fragment(R.layout.fragment_game_card_boloot) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bolootList=ArrayList<BolootData>()

        bolootList.add(BolootData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        bolootList.add(BolootData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        bolootList.add(BolootData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        bolootList.add(BolootData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        bolootList.add(BolootData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        bolootList.add(BolootData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        bolootList.add(BolootData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        bolootList.add(BolootData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        boloot_rv.adapter = BolootAdapter(bolootList)
        boloot_rv.layoutManager = GridLayoutManager(context,2)
        boloot_rv.setHasFixedSize(true)

    }
}