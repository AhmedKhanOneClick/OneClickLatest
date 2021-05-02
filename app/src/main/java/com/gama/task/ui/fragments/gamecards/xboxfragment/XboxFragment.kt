package com.gama.task.ui.fragments.gamecards.xboxfragment

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
import com.gama.task.ui.fragments.gamecards.GameCardDirections
import com.gama.task.ui.fragments.gamecards.pubgfragment.PubgAdapter
import com.gama.task.ui.fragments.gamecards.pubgfragment.PubgData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_game_card_playstation.*
import kotlinx.android.synthetic.main.fragment_game_card_xbox.*

class XboxFragment:Fragment(R.layout.fragment_game_card_xbox),XboxAdapter.OnItemClickListener{


    val xboxList=ArrayList<XboxData>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)



    xboxList.add(XboxData("2GB Per Month", 50, "100","XBox Recharg Card 50 SAR"))
    xboxList.add(XboxData("5GB Per Month", 100, "200","XBox Recharg Card 100 SAR"))
    xboxList.add(XboxData("10GB Per Month", 150, "300","XBox Recharg Card 150 SAR"))
    xboxList.add(XboxData("15GB Per Month", 200, "400","XBox Recharg Card 200 SAR"))
    xboxList.add(XboxData("20GB Per Month", 250, "500","XBox Recharg Card 250 SAR"))
    xboxList.add(XboxData("25GB Per Month", 300, "600","XBox Recharg Card 300 SAR"))
    xboxList.add(XboxData("30GB Per Month", 350, "700","XBox Recharg Card 350 SAR"))
    xboxList.add(XboxData("40GB Per Month", 400, "800","XBox Recharg Card 400 SAR"))

    xbox_rv.adapter = XboxAdapter(xboxList,this)
    xbox_rv.layoutManager = GridLayoutManager(context,2)
    xbox_rv.setHasFixedSize(true)





}

    override fun onClick(position: Int) {
        Log.e("click Xbox","card number $position")
        Toast.makeText(activity, "added Xbox card num $position to cart", Toast.LENGTH_LONG).show()
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.xbox_logo
            ,xboxList.get(position).text2
            ,xboxList.get(position).text3
            ,xboxList.get(position).text4)
        )

if (!GlobalClass.globalCartList.isEmpty())
    findNavController().navigate(XboxFragmentDirections.actionXboxFragmentToBottomSheetCheckOut22())

    }

    override fun onLongClick(position: Int) {
        Log.e("Long Click Xbox","card number $position")
    }
}