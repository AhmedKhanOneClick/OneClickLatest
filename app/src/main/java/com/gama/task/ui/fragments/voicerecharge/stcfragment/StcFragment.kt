package com.gama.task.ui.fragments.voicerecharge.stcfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.card_friendi_item2.view.*
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_voice_card_stc.*

class StcFragment : Fragment(R.layout.fragment_voice_card_stc) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val stcList=ArrayList<StcData>()

        stcList.add(StcData("Voice Recharge", "19.62", "20","STC Recharge Card 20 SAR"))
        stcList.add(StcData("Voice Recharge", "22.56", "23","STC Recharge Card 23 SAR"))
        stcList.add(StcData("Voice Recharge", "28.20", "28.75","STC Recharge Card 28.75 SAR"))
        stcList.add(StcData("Voice Recharge", "33.84", "34.50","STC Recharge Card 34.50 SAR"))
        stcList.add(StcData("Voice Recharge", "56.40", "15","STC Recharge Card 57.50 SAR"))
        stcList.add(StcData("Voice Recharge", "112.80", "115","STC Recharge Card 115 SAR"))
        stcList.add(StcData("Voice Recharge", "225.60", "230","STC Recharge Card 230 SAR"))
        stcList.add(StcData("Voice Recharge", "338.40", "345","STC Recharge Card 345 SAR"))
        Vstc_rv.adapter = StcAdapter(stcList)
        Vstc_rv.layoutManager = GridLayoutManager(context,2)
        Vstc_rv.setHasFixedSize(true)

    }
}