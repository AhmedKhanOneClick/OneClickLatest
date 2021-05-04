package com.gama.task.ui.fragments.voicedatacharg.mobilyfragment

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
import kotlinx.android.synthetic.main.fragment_data_card_mobily.*

class MobilyFragment : Fragment(R.layout.fragment_data_card_mobily),MobilyAdapter.OnItemClickListener {
    val mobilyList=ArrayList<MobilyData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        mobilyList.add(MobilyData("2GB Per Month", "50".toInt(), "100","Nintendo Recharg Card 50 SAR"))
        mobilyList.add(MobilyData("5GB Per Month", "100".toInt(), "200","Nintendo Recharg Card 100 SAR"))
        mobilyList.add(MobilyData("10GB Per Month", "150".toInt(), "300","Nintendo Recharg Card 150 SAR"))
        mobilyList.add(MobilyData("15GB Per Month", "200".toInt(), "400","Nintendo Recharg Card 200 SAR"))
        mobilyList.add(MobilyData("20GB Per Month", "250".toInt(), "500","Nintendo Recharg Card 250 SAR"))
        mobilyList.add(MobilyData("25GB Per Month", "300".toInt(), "600","Nintendo Recharg Card 300 SAR"))
        mobilyList.add(MobilyData("30GB Per Month", "350".toInt(), "700","Nintendo Recharg Card 350 SAR"))
        mobilyList.add(MobilyData("40GB Per Month", "400".toInt(), "800","Nintendo Recharg Card 400 SAR"))
        mobily_rv.adapter = MobilyAdapter(mobilyList,this)
        mobily_rv.layoutManager = GridLayoutManager(context,2)
        mobily_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.mobily
                ,mobilyList.get(position).text2
                ,mobilyList.get(position).text3
                ,mobilyList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(MobilyFragmentDirections.actionMobilyFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}