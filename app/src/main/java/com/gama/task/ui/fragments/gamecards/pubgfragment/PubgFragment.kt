package com.gama.task.ui.fragments.gamecards.pubgfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.gamecards.playstationfragment.PlayStationAdapter
import kotlinx.android.synthetic.main.fragment_game_card_playstation.*
import kotlinx.android.synthetic.main.fragment_game_card_pubg.*

class PubgFragment:Fragment(R.layout.fragment_game_card_pubg){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val pubgList=ArrayList<PubgData>()

        pubgList.add(PubgData("2GB Per Month", "50", "100","PUBG Recharg Card 50 SAR"))
        pubgList.add(PubgData("5GB Per Month", "100", "200","PUBG Recharg Card 100 SAR"))
        pubgList.add(PubgData("10GB Per Month", "150", "300","PUBG Recharg Card 150 SAR"))
        pubgList.add(PubgData("15GB Per Month", "200", "400","PUBG Recharg Card 200 SAR"))
        pubgList.add(PubgData("20GB Per Month", "250", "500","PUBG Recharg Card 250 SAR"))
        pubgList.add(PubgData("25GB Per Month", "300", "600","PUBG Recharg Card 300 SAR"))
        pubgList.add(PubgData("30GB Per Month", "350", "700","PUBG Recharg Card 350 SAR"))
        pubgList.add(PubgData("40GB Per Month", "400", "800","PUBG Recharg Card 400 SAR"))

        pubg_rv.adapter = PubgAdapter(pubgList)
        pubg_rv.layoutManager = GridLayoutManager(context,2)
        pubg_rv.setHasFixedSize(true)
    }
}