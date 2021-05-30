package com.gama.task.ui.fragments.gamecards.xboxfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_game_card_xbox.*

class XboxFragment:Fragment(R.layout.fragment_game_card_xbox),XboxAdapter.OnItemClickListener{

    val xboxList=ArrayList<XboxData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)



    xboxList.add(XboxData("2GB Per Month", "50".toInt(), "100","XBox Recharg Card 50 SAR"))
    xboxList.add(XboxData("5GB Per Month", "100".toInt(), "200","XBox Recharg Card 100 SAR"))
    xboxList.add(XboxData("10GB Per Month", "150".toInt(), "300","XBox Recharg Card 150 SAR"))
    xboxList.add(XboxData("15GB Per Month", "200".toInt(), "400","XBox Recharg Card 200 SAR"))
    xboxList.add(XboxData("20GB Per Month", "250".toInt(), "500","XBox Recharg Card 250 SAR"))
    xboxList.add(XboxData("25GB Per Month", "300".toInt(), "600","XBox Recharg Card 300 SAR"))
    xboxList.add(XboxData("30GB Per Month", "350".toInt(), "700","XBox Recharg Card 350 SAR"))
    xboxList.add(XboxData("40GB Per Month", "400".toInt(), "800","XBox Recharg Card 400 SAR"))

    xbox_rv.adapter = XboxAdapter(xboxList,this)
    xbox_rv.layoutManager = GridLayoutManager(context,2)
    xbox_rv.setHasFixedSize(true)
}

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.vip_jalsaat
                ,xboxList.get(position).text2
                ,xboxList.get(position).text3
                ,xboxList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(XboxFragmentDirections.actionXboxFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}