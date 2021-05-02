package com.gama.task.ui.fragments.voicedatacharg.gofragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_data_card_go.*

class GoFragment : Fragment(R.layout.fragment_data_card_go) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val goList=ArrayList<GoData>()

        goList.add(GoData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        goList.add(GoData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        goList.add(GoData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        goList.add(GoData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        goList.add(GoData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        goList.add(GoData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        goList.add(GoData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        goList.add(GoData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        go_rv.adapter = GoAdapter(goList)
        go_rv.layoutManager = GridLayoutManager(context,2)
        go_rv.setHasFixedSize(true)

    }
}