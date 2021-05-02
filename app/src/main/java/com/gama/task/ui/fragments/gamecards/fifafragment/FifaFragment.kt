package com.gama.task.ui.fragments.gamecards.fifafragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_game_card_fifa.*


class FifaFragment : Fragment(R.layout.fragment_game_card_fifa) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val fifaList=ArrayList<FifaData>()

        fifaList.add(FifaData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        fifaList.add(FifaData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        fifaList.add(FifaData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        fifaList.add(FifaData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        fifaList.add(FifaData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        fifaList.add(FifaData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        fifaList.add(FifaData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        fifaList.add(FifaData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        fifa_rv.adapter = FifaAdapter(fifaList)
        fifa_rv.layoutManager = GridLayoutManager(context,2)
        fifa_rv.setHasFixedSize(true)

    }
}