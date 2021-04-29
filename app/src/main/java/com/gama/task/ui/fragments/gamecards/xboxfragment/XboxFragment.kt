package com.gama.task.ui.fragments.gamecards.xboxfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_game_card_xbox.*

class XboxFragment:Fragment(R.layout.fragment_game_card_xbox){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)


    val xboxList=ArrayList<XboxData>()

    xboxList.add(XboxData("2GB Per Month", "50", "100","XBox Recharg Card 50 SAR"))
    xboxList.add(XboxData("5GB Per Month", "100", "200","XBox Recharg Card 100 SAR"))
    xboxList.add(XboxData("10GB Per Month", "150", "300","XBox Recharg Card 150 SAR"))
    xboxList.add(XboxData("15GB Per Month", "200", "400","XBox Recharg Card 200 SAR"))
    xboxList.add(XboxData("20GB Per Month", "250", "500","XBox Recharg Card 250 SAR"))
    xboxList.add(XboxData("25GB Per Month", "300", "600","XBox Recharg Card 300 SAR"))
    xboxList.add(XboxData("30GB Per Month", "350", "700","XBox Recharg Card 350 SAR"))
    xboxList.add(XboxData("40GB Per Month", "400", "800","XBox Recharg Card 400 SAR"))

    xbox_rv.adapter = XboxAdapter(xboxList)
    xbox_rv.layoutManager = GridLayoutManager(context,2)
    xbox_rv.setHasFixedSize(true)
}
}