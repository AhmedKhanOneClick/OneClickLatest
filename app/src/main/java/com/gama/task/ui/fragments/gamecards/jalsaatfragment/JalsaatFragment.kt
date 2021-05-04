package com.gama.task.ui.fragments.gamecards.jalsaatfragment

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
import kotlinx.android.synthetic.main.fragment_game_card_jalsaat.*
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*

class JalsaatFragment : Fragment(R.layout.fragment_game_card_jalsaat),JalsaatAdapter.OnItemClickListener {

    val jalsaatList=ArrayList<JalsaatData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        jalsaatList.add(JalsaatData("2GB Per Month", "50".toInt(), "100","Jalsaat Recharg Card 50 SAR"))
        jalsaatList.add(JalsaatData("5GB Per Month", "100".toInt(), "200","Jalsaat Recharg Card 100 SAR"))
        jalsaatList.add(JalsaatData("10GB Per Month", "150".toInt(), "300","Jalsaat Recharg Card 150 SAR"))
        jalsaatList.add(JalsaatData("15GB Per Month", "200".toInt(), "400","Jalsaat Recharg Card 200 SAR"))
        jalsaatList.add(JalsaatData("20GB Per Month", "250".toInt(), "500","Jalsaat Recharg Card 250 SAR"))
        jalsaatList.add(JalsaatData("25GB Per Month", "300".toInt(), "600","Jalsaat Recharg Card 300 SAR"))
        jalsaatList.add(JalsaatData("30GB Per Month", "350".toInt(), "700","Jalsaat Recharg Card 350 SAR"))
        jalsaatList.add(JalsaatData("40GB Per Month", "400".toInt(), "800","Jalsaat Recharg Card 400 SAR"))
        jalsaat_rv.adapter = JalsaatAdapter(jalsaatList,this)
        jalsaat_rv.layoutManager = GridLayoutManager(context,2)
        jalsaat_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.vip_jalsaat
                ,jalsaatList.get(position).text2
                ,jalsaatList.get(position).text3
                ,jalsaatList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(JalsaatFragmentDirections.actionJalsaatFragmentToBottomSheetCheckOut())
            findNavController().navigate(JalsaatFragmentDirections.actionJalsaatFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}