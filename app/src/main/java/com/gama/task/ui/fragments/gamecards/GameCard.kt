package com.gama.task.ui.fragments.gamecards

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_game_card.*


class GameCard : Fragment(R.layout.fragment_game_card) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        xbox_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToXboxFragment()
            findNavController().navigate(action)
        }
        playstation_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToPlayStationFragment()
            findNavController().navigate(action)
        }
        nintend_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToNintendFragment()
            findNavController().navigate(action)
        }
        pubg_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToPubgFragment()
            findNavController().navigate(action)
        }


    }



}