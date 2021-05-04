package com.gama.task.ui.fragments.voicedatacharg.friendfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.gamecards.bolootfragment.BolootAdapter
import com.gama.task.ui.fragments.gamecards.bolootfragment.BolootData
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_game_card_boloot.*

class FrindFragment : Fragment(R.layout.fragment_data_card_friendi),FriendiAdapter.OnItemClickListener {

    val friendiList=ArrayList<FriendiData>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        friendiList.add(FriendiData("2GB Per Month", "50".toInt(), "100","Frind Recharg Card 50 SAR"))
        friendiList.add(FriendiData("5GB Per Month", "100".toInt(), "200","Frind Recharg Card 100 SAR"))
        friendiList.add(FriendiData("10GB Per Month", "150".toInt(), "300","Frind Recharg Card 150 SAR"))
        friendiList.add(FriendiData("15GB Per Month", "200".toInt(), "400","Frind Recharg Card 200 SAR"))
        friendiList.add(FriendiData("20GB Per Month", "250".toInt(), "500","Frind Recharg Card 250 SAR"))
        friendiList.add(FriendiData("25GB Per Month", "300".toInt(), "600","Frind Recharg Card 300 SAR"))
        friendiList.add(FriendiData("30GB Per Month", "350".toInt(), "700","Frind Recharg Card 350 SAR"))
        friendiList.add(FriendiData("40GB Per Month", "400".toInt(), "800","Frind Recharg Card 400 SAR"))
        friendi_rv.adapter = FriendiAdapter(friendiList,this)
        friendi_rv.layoutManager = GridLayoutManager(context,2)
        friendi_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.friendi
                ,friendiList.get(position).text2
                ,friendiList.get(position).text3
                ,friendiList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(FrindFragmentDirections.actionFriendFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}