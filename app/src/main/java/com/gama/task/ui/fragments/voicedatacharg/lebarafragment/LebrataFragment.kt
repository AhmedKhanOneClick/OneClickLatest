package com.gama.task.ui.fragments.voicedatacharg.lebarafragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_data_card_lebara.*

class LebrataFragment : Fragment(R.layout.fragment_data_card_lebara) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val lebaraList=ArrayList<LebaraData>()

        lebaraList.add(LebaraData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        lebaraList.add(LebaraData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        lebaraList.add(LebaraData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        lebaraList.add(LebaraData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        lebaraList.add(LebaraData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        lebaraList.add(LebaraData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        lebaraList.add(LebaraData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        lebaraList.add(LebaraData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        lebara_rv.adapter = LebaraAdapter(lebaraList)
        lebara_rv.layoutManager = GridLayoutManager(context,2)
        lebara_rv.setHasFixedSize(true)

    }
}