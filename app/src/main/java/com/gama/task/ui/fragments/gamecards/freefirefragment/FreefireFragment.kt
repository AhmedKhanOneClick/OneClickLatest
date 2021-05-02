package com.gama.task.ui.fragments.gamecards.freefirefragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.fragment_game_card_freefire.*
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*

class FreefireFragment : Fragment(R.layout.fragment_game_card_freefire) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val freefireList=ArrayList<FreefireData>()

        freefireList.add(FreefireData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        freefireList.add(FreefireData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        freefireList.add(FreefireData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        freefireList.add(FreefireData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        freefireList.add(FreefireData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        freefireList.add(FreefireData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        freefireList.add(FreefireData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        freefireList.add(FreefireData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        freefire_rv.adapter = FreefireAdapter(freefireList)
        freefire_rv.layoutManager = GridLayoutManager(context,2)
        freefire_rv.setHasFixedSize(true)

    }
}