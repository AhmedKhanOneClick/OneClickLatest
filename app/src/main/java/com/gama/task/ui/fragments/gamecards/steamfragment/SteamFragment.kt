package com.gama.task.ui.fragments.gamecards.steamfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.fragment_game_card_steam.*


class SteamFragment : Fragment(R.layout.fragment_game_card_steam),SteamAdapter.OnItemClickListener {
    val steamList=ArrayList<SteamData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        steamList.add(SteamData("2GB Per Month", "50".toInt(), "100","steam Recharg Card 50 SAR"))
        steamList.add(SteamData("5GB Per Month", "100".toInt(), "200","steam Recharg Card 100 SAR"))
        steamList.add(SteamData("10GB Per Month", "150".toInt(), "300","steam Recharg Card 150 SAR"))
        steamList.add(SteamData("15GB Per Month", "200".toInt(), "400","steam Recharg Card 200 SAR"))
        steamList.add(SteamData("20GB Per Month", "250".toInt(), "500","steam Recharg Card 250 SAR"))
        steamList.add(SteamData("25GB Per Month", "300".toInt(), "600","steam Recharg Card 300 SAR"))
        steamList.add(SteamData("30GB Per Month", "350".toInt(), "700","steam Recharg Card 350 SAR"))
        steamList.add(SteamData("40GB Per Month", "400".toInt(), "800","steam Recharg Card 400 SAR"))
        steam_rv.adapter = SteamAdapter(steamList,this)
        steam_rv.layoutManager = GridLayoutManager(context,2)
        steam_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.steam
                ,steamList.get(position).text2
                ,steamList.get(position).text3
                ,steamList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(SteamFragmentDirections.actionSteamFragmentToBottomSheetCheckOut())

    }

    override fun onLongClick(position: Int) {

    }
}