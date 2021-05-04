package com.gama.task.ui.fragments.gamecards.bolootfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_game_card_boloot.*


class BolootFragment : Fragment(R.layout.fragment_game_card_boloot),BolootAdapter.OnItemClickListener {
    val bolootList=ArrayList<BolootData>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        bolootList.add(BolootData("2GB Per Month", 50, "100","Boloot Recharg Card 50 SAR"))
        bolootList.add(BolootData("5GB Per Month", 100, "200","Boloot Recharg Card 100 SAR"))
        bolootList.add(BolootData("10GB Per Month", 200, "300","Boloot Recharg Card 150 SAR"))
        bolootList.add(BolootData("15GB Per Month", 300, "400","Boloot Recharg Card 200 SAR"))
        bolootList.add(BolootData("20GB Per Month", 250, "500","Boloot Recharg Card 250 SAR"))
        bolootList.add(BolootData("25GB Per Month", 300, "600","Boloot Recharg Card 300 SAR"))
        bolootList.add(BolootData("30GB Per Month", 350, "700","Boloot Recharg Card 350 SAR"))
        bolootList.add(BolootData("40GB Per Month", 400, "800","Boloot Recharg Card 400 SAR"))
        boloot_rv.adapter = BolootAdapter(bolootList,this)
        boloot_rv.layoutManager = GridLayoutManager(context,2)
        boloot_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.vip_boloot
                ,bolootList.get(position).text2
                ,bolootList.get(position).text3
                ,bolootList.get(position).text4))
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(BolootFragmentDirections.actionBolootFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}