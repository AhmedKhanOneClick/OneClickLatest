package com.gama.task.ui.fragments.voicedatacharg.zainfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_data_card_zain.*

class ZainFragment : Fragment(R.layout.fragment_data_card_zain) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val zainList=ArrayList<ZainData>()

        zainList.add(ZainData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        zainList.add(ZainData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        zainList.add(ZainData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        zainList.add(ZainData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        zainList.add(ZainData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        zainList.add(ZainData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        zainList.add(ZainData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        zainList.add(ZainData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        zain_rv.adapter = ZainAdapter(zainList)
        zain_rv.layoutManager = GridLayoutManager(context,2)
        zain_rv.setHasFixedSize(true)

    }
}