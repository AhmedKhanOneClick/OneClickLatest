package com.gama.task.ui.fragments.gamecards.nintendofragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_game_card_nintend.*

class NintendFragment:Fragment(R.layout.fragment_game_card_nintend),NintendAdapter.OnItemClickListener{

    val nintedList=ArrayList<NintendData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        nintedList.add(NintendData("2GB Per Month", "50".toInt(), "100","Nintendo Recharg Card 50 SAR"))
        nintedList.add(NintendData("5GB Per Month", "100".toInt(), "200","Nintendo Recharg Card 100 SAR"))
        nintedList.add(NintendData("10GB Per Month", "150".toInt(), "300","Nintendo Recharg Card 150 SAR"))
        nintedList.add(NintendData("15GB Per Month", "200".toInt(), "400","Nintendo Recharg Card 200 SAR"))
        nintedList.add(NintendData("20GB Per Month", "250".toInt(), "500","Nintendo Recharg Card 250 SAR"))
        nintedList.add(NintendData("25GB Per Month", "300".toInt(), "600","Nintendo Recharg Card 300 SAR"))
        nintedList.add(NintendData("30GB Per Month", "350".toInt(), "700","Nintendo Recharg Card 350 SAR"))
        nintedList.add(NintendData("40GB Per Month", "400".toInt(), "800","Nintendo Recharg Card 400 SAR"))
        nintendo_rv.adapter = NintendAdapter(nintedList,this)
        nintendo_rv.layoutManager = GridLayoutManager(context,2)
        nintendo_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.nintendo
                ,nintedList.get(position).text2
                ,nintedList.get(position).text3
                ,nintedList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(NintendFragmentDirections.actionNintendFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }


}