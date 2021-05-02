package com.gama.task.ui.fragments.voicedatacharg.stcfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_data_card_stc.*

class StcFragment : Fragment(R.layout.fragment_data_card_stc) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val stcList=ArrayList<StcData>()

        stcList.add(StcData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        stcList.add(StcData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        stcList.add(StcData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        stcList.add(StcData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        stcList.add(StcData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        stcList.add(StcData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        stcList.add(StcData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        stcList.add(StcData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        stc_rv.adapter = StcAdapter(stcList)
        stc_rv.layoutManager = GridLayoutManager(context,2)
        stc_rv.setHasFixedSize(true)

    }
}