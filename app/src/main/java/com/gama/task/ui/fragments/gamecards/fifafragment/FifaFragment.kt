package com.gama.task.ui.fragments.gamecards.fifafragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_game_card_fifa.*


class FifaFragment : Fragment(R.layout.fragment_game_card_fifa),FifaAdapter.OnItemClickListener {
    val fifaList=ArrayList<FifaData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        fifaList.add(FifaData("2GB Per Month", "50".toInt(), "100","Fifa Recharg Card 50 SAR"))
        fifaList.add(FifaData("5GB Per Month", "100".toInt(), "200","Fifa Recharg Card 100 SAR"))
        fifaList.add(FifaData("10GB Per Month", "150".toInt(), "300","Fifa Recharg Card 150 SAR"))
        fifaList.add(FifaData("15GB Per Month", "200".toInt(), "400","Fifa Recharg Card 200 SAR"))
        fifaList.add(FifaData("20GB Per Month", "250".toInt(), "500","Fifa Recharg Card 250 SAR"))
        fifaList.add(FifaData("25GB Per Month", "300".toInt(), "600","Fifa Recharg Card 300 SAR"))
        fifaList.add(FifaData("30GB Per Month", "350".toInt(), "700","Fifa Recharg Card 350 SAR"))
        fifaList.add(FifaData("40GB Per Month", "400".toInt(), "800","Fifa Recharg Card 400 SAR"))
        fifa_rv.adapter = FifaAdapter(fifaList,this)
        fifa_rv.layoutManager = GridLayoutManager(context,2)
        fifa_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {

        GlobalClass.globalCartList.add(
            CartItem(R.drawable.fifa
                ,fifaList.get(position).text2
                ,fifaList.get(position).text3
                ,fifaList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(FifaFragmentDirections.actionFifaFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}