package com.gama.task.ui.fragments.cinemacards

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
//import com.gama.task.ui.fragments.CinemaCardDirections
import kotlinx.android.synthetic.main.fragment_cinema_card.*

class CinemaCard:Fragment(R.layout.fragment_cinema_card)  {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        starzplay_btn.setOnClickListener {
            val action=
                CinemaCardDirections.actionCinemaCardFragmentToStarzPlayFragment()
            findNavController().navigate(action)
        }
        netflix_btn.setOnClickListener {
            val action=
                CinemaCardDirections.actionCinemaCardFragmentToNetflixFragment()
            findNavController().navigate(action)
        }
        shahid_btn.setOnClickListener{
            val action = CinemaCardDirections.actionCinemaCardFragmentToShahidFragment()
            findNavController().navigate(action)
        }
        weyyak_btn.setOnClickListener {
            val action=
                CinemaCardDirections.actionCinemaCardFragmentToWeyyakFragment()
            findNavController().navigate(action)
        }
        kitaabsawti_btn.setOnClickListener {
            val action=
                CinemaCardDirections.actionCinemaCardFragmentToKitaabsawtiFragment()
            findNavController().navigate(action)
        }
//
    }
}