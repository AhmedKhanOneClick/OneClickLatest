package com.gama.task.ui.fragments.voicedatacharg.gofragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_data_card_go.*

class GoFragment : Fragment(R.layout.fragment_data_card_go),GoAdapter.OnItemClickListener {
    val goList=ArrayList<GoData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        goList.add(GoData("2GB Per Month", "50".toInt(), "100","Go Recharg Card 50 SAR"))
        goList.add(GoData("5GB Per Month", "100".toInt(), "200","Go Recharg Card 100 SAR"))
        goList.add(GoData("10GB Per Month", "150".toInt(), "300","Go Recharg Card 150 SAR"))
        goList.add(GoData("15GB Per Month", "200".toInt(), "400","Go Recharg Card 200 SAR"))
        goList.add(GoData("20GB Per Month", "250".toInt(), "500","Go Recharg Card 250 SAR"))
        goList.add(GoData("25GB Per Month", "300".toInt(), "600","Go Recharg Card 300 SAR"))
        goList.add(GoData("30GB Per Month", "350".toInt(), "700","Go Recharg Card 350 SAR"))
        goList.add(GoData("40GB Per Month", "400".toInt(), "800","Go Recharg Card 400 SAR"))
        go_rv.adapter = GoAdapter(goList,this)
        go_rv.layoutManager = GridLayoutManager(context,2)
        go_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.go
                ,goList.get(position).text2
                ,goList.get(position).text3
                ,goList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(GoFragmentDirections.actionGoFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}