package com.gama.task.ui.fragments.gamecards.playstationfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.gamecards.xboxfragment.XboxFragmentDirections
import kotlinx.android.synthetic.main.fragment_game_card_playstation.*

class PlayStationFragment:Fragment(R.layout.fragment_game_card_playstation),PlayStationAdapter.OnItemClickListener{
    val playstationList=ArrayList<PlayStationData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            playstationList.add(PlayStationData("2GB Per Month", 50, "100","Playstation Recharg Card 50 SAR"))
            playstationList.add(PlayStationData("5GB Per Month", 100, "200","Playstation Recharg Card 100 SAR"))
            playstationList.add(PlayStationData("10GB Per Month", 150, "300","Playstation Recharg Card 150 SAR"))
            playstationList.add(PlayStationData("15GB Per Month", 200, "400","Playstation Recharg Card 200 SAR"))
            playstationList.add(PlayStationData("20GB Per Month", 250, "500","Playstation Recharg Card 250 SAR"))
            playstationList.add(PlayStationData("25GB Per Month", 300, "600","Playstation Recharg Card 300 SAR"))
            playstationList.add(PlayStationData("30GB Per Month", 350, "700","Playstation Recharg Card 350 SAR"))
            playstationList.add(PlayStationData("40GB Per Month", 400, "800","Playstation Recharg Card 400 SAR"))

        playstation_rv.adapter = PlayStationAdapter(playstationList,this)
        playstation_rv.layoutManager = GridLayoutManager(context,2)
        playstation_rv.setHasFixedSize(true)

        }

    override fun onClickL(position: Int) {
        Log.e("click Playstation","card number $position")

        Toast.makeText(activity, "added Playstation card num $position to cart", Toast.LENGTH_LONG).show()

        GlobalClass.globalCartList.add(
            CartItem(R.drawable.ps_logo
                ,playstationList.get(position).text2
                ,playstationList.get(position).text3
                ,playstationList.get(position).text4))

        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(XboxFragmentDirections.actionXboxFragmentToBottomSheetCheckOut2())

    }

    override fun onLongClick(position: Int) {
        Log.e("Long click Playstation","card number $position")
    }
}
