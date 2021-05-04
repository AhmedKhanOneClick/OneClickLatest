package com.gama.task.ui.fragments.gamecards.legendsfragment

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
import kotlinx.android.synthetic.main.fragment_game_card_legends.*
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*

class LegendsFragment : Fragment(R.layout.fragment_game_card_legends),LegendsAdapter.OnItemClickListener {
    val legendsList=ArrayList<LegendsData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        legendsList.add(LegendsData("2GB Per Month", "50".toInt(), "100","Legends Recharg Card 50 SAR"))
        legendsList.add(LegendsData("5GB Per Month", "100".toInt(), "200","Legends Recharg Card 100 SAR"))
        legendsList.add(LegendsData("10GB Per Month", "150".toInt(), "300","Legends Recharg Card 150 SAR"))
        legendsList.add(LegendsData("15GB Per Month", "200".toInt(), "400","Legends Recharg Card 200 SAR"))
        legendsList.add(LegendsData("20GB Per Month", "250".toInt(), "500","Legends Recharg Card 250 SAR"))
        legendsList.add(LegendsData("25GB Per Month", "300".toInt(), "600","Legends Recharg Card 300 SAR"))
        legendsList.add(LegendsData("30GB Per Month", "350".toInt(), "700","Legends Recharg Card 350 SAR"))
        legendsList.add(LegendsData("40GB Per Month", "400".toInt(), "800","Legends Recharg Card 400 SAR"))
        legends_rv.adapter = LegendsAdapter(legendsList,this)
        legends_rv.layoutManager = GridLayoutManager(context,2)
        legends_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.mobile_legends
                ,legendsList.get(position).text2
                ,legendsList.get(position).text3
                ,legendsList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(LegendsFragmentDirections.actionLegendsFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}