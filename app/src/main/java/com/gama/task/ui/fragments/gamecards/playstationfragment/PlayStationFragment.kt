package com.gama.task.ui.fragments.gamecards.playstationfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.gamecards.nintendofragment.NintendAdapter
import com.gama.task.ui.fragments.gamecards.nintendofragment.NintendData
import kotlinx.android.synthetic.main.fragment_game_card_nintend.*
import kotlinx.android.synthetic.main.fragment_game_card_playstation.*

class PlayStationFragment:Fragment(R.layout.fragment_game_card_playstation){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val playstationList=ArrayList<PlayStationData>()

            playstationList.add(PlayStationData("2GB Per Month", "50", "100","Playstation Recharg Card 50 SAR"))
            playstationList.add(PlayStationData("5GB Per Month", "100", "200","Playstation Recharg Card 100 SAR"))
            playstationList.add(PlayStationData("10GB Per Month", "150", "300","Playstation Recharg Card 150 SAR"))
            playstationList.add(PlayStationData("15GB Per Month", "200", "400","Playstation Recharg Card 200 SAR"))
            playstationList.add(PlayStationData("20GB Per Month", "250", "500","Playstation Recharg Card 250 SAR"))
            playstationList.add(PlayStationData("25GB Per Month", "300", "600","Playstation Recharg Card 300 SAR"))
            playstationList.add(PlayStationData("30GB Per Month", "350", "700","Playstation Recharg Card 350 SAR"))
            playstationList.add(PlayStationData("40GB Per Month", "400", "800","Playstation Recharg Card 400 SAR"))

        playstation_rv.adapter = PlayStationAdapter(playstationList)
        playstation_rv.layoutManager = GridLayoutManager(context,2)
        playstation_rv.setHasFixedSize(true)

        }
    }
