package com.gama.task.ui.fragments.gamecards.nintendofragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_game_card_nintend.*

class NintendFragment:Fragment(R.layout.fragment_game_card_nintend){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


      val nintedList=ArrayList<NintendData>()

        nintedList.add(NintendData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        nintedList.add(NintendData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        nintedList.add(NintendData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        nintedList.add(NintendData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        nintedList.add(NintendData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        nintedList.add(NintendData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        nintedList.add(NintendData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        nintedList.add(NintendData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        nintendo_rv.adapter = NintendAdapter(nintedList)
        nintendo_rv.layoutManager = GridLayoutManager(context,2)
        nintendo_rv.setHasFixedSize(true)

    }



}