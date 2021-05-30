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
        boloot_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToBolootFragment()
            findNavController().navigate(action)
        }
        fifa_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToFifaFragment()
            findNavController().navigate(action)
        }
        freefire_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToFreefireFragment()
            findNavController().navigate(action)
        }
        jalsaat_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToJalsaatFragment()
            findNavController().navigate(action)
        }
        legends_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToLegendsFragment()
            findNavController().navigate(action)
        }
        lords_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToLordsFragment()
            findNavController().navigate(action)
        }
        steam_btn.setOnClickListener {
            val action=
                GameCardDirections.actionGameCardToSteamFragment()
            findNavController().navigate(action)
        }
    }



}