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

        friendiList.add(FriendiData("1.5GB for 1 Month", "37".toInt(), "37","Freindi Data Card 37 SAR"))
        friendiList.add(FriendiData("3GB for 1 Month", "52".toInt(), "52","Freindi Data Card 52 SAR"))
        friendiList.add(FriendiData("5GB for 1 Month", "63".toInt(), "63","Freindi Data Card 63 SAR"))
        friendiList.add(FriendiData("8GB for 1 Month", "94".toInt(), "94","Freindi Data Card 94 SAR"))
        friendiList.add(FriendiData("10GB for 1 Month", "105".toInt(), "105","Freindi Data Card 105 SAR"))
        friendiList.add(FriendiData("10GB for 3 Months", "130".toInt(), "130","Freindi Data Card 130 SAR"))
        friendiList.add(FriendiData("20GB for 3 Month", "199".toInt(), "199","Freindi Data Card 199 SAR"))
        friendiList.add(FriendiData("50GB for 3 Month", "274".toInt(), "274","Freindi Data Card 274 SAR"))

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