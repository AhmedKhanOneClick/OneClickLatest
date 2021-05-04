package com.gama.task.ui.fragments.gamecards.freefirefragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.gamecards.fifafragment.FifaAdapter
import kotlinx.android.synthetic.main.fragment_game_card_freefire.*

class FreefireFragment : Fragment(R.layout.fragment_game_card_freefire),FreefireAdapter.OnItemClickListener{
    val freefireList=ArrayList<FreefireData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        freefireList.add(FreefireData("2GB Per Month", "50".toInt(), "100","Freefire Recharg Card 50 SAR"))
        freefireList.add(FreefireData("5GB Per Month", "100".toInt(), "200","Freefire Recharg Card 100 SAR"))
        freefireList.add(FreefireData("10GB Per Month", "150".toInt(), "300","Freefire Recharg Card 150 SAR"))
        freefireList.add(FreefireData("15GB Per Month", "200".toInt(), "400","Freefire Recharg Card 200 SAR"))
        freefireList.add(FreefireData("20GB Per Month", "250".toInt(), "500","Freefire Recharg Card 250 SAR"))
        freefireList.add(FreefireData("25GB Per Month", "300".toInt(), "600","Freefire Recharg Card 300 SAR"))
        freefireList.add(FreefireData("30GB Per Month", "350".toInt(), "700","Freefire Recharg Card 350 SAR"))
        freefireList.add(FreefireData("40GB Per Month", "400".toInt(), "800","Freefire Recharg Card 400 SAR"))
        freefire_rv.adapter = FreefireAdapter(freefireList,this)
        freefire_rv.layoutManager = GridLayoutManager(context,2)
        freefire_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.freefire
                ,freefireList.get(position).text2
                ,freefireList.get(position).text3
                ,freefireList.get(position).text4))
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(FreefireFragmentDirections.actionFreefireFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}