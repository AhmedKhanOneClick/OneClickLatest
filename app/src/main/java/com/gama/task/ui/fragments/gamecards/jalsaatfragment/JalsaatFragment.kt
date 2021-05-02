package com.gama.task.ui.fragments.gamecards.jalsaatfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.fragment_game_card_jalsaat.*
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*

class JalsaatFragment : Fragment(R.layout.fragment_game_card_jalsaat) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val jalsaatList=ArrayList<JalsaatData>()

        jalsaatList.add(JalsaatData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        jalsaatList.add(JalsaatData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        jalsaatList.add(JalsaatData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        jalsaatList.add(JalsaatData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        jalsaatList.add(JalsaatData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        jalsaatList.add(JalsaatData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        jalsaatList.add(JalsaatData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        jalsaatList.add(JalsaatData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        jalsaat_rv.adapter = JalsaatAdapter(jalsaatList)
        jalsaat_rv.layoutManager = GridLayoutManager(context,2)
        jalsaat_rv.setHasFixedSize(true)

    }
}