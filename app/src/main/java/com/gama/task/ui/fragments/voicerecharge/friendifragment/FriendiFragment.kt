package com.gama.task.ui.fragments.voicerecharge.friendifragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.voicerecharge.friendifragment.FriendiAdapter
import com.gama.task.ui.fragments.voicerecharge.friendifragment.FriendiData
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*

class FriendiFragment : Fragment(R.layout.fragment_voice_card_friendi) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val friendiList=ArrayList<FriendiData>()

        friendiList.add(FriendiData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        friendiList.add(FriendiData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        friendiList.add(FriendiData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        friendiList.add(FriendiData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        friendiList.add(FriendiData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        friendiList.add(FriendiData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        friendiList.add(FriendiData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        friendiList.add(FriendiData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        friendi_rv.adapter = FriendiAdapter(friendiList)
        friendi_rv.layoutManager = GridLayoutManager(context,2)
        friendi_rv.setHasFixedSize(true)

    }
}