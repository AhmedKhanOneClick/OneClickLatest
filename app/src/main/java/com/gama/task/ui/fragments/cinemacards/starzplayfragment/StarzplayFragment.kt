package com.gama.task.ui.fragments.cinemacards.starzplayfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_cinema_card_starzplay.*


//class StarzplayFragment {
//}
class StarzplayFragment: Fragment(R.layout.fragment_cinema_card_starzplay),StarzplayAdapter.OnItemClickListener{


    val StarzplayList=ArrayList<StarzplayData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        StarzplayList.add(StarzplayData("2GB Per Month", 51, "100","Starzplay Recharg Card 50 SAR"))
        StarzplayList.add(StarzplayData("5GB Per Month", 100, "200","Starzplay Recharg Card 100 SAR"))
        StarzplayList.add(StarzplayData("10GB Per Month", 150, "300","Starzplay Recharg Card 150 SAR"))
        StarzplayList.add(StarzplayData("15GB Per Month", 200, "400","Starzplay Recharg Card 200 SAR"))
        StarzplayList.add(StarzplayData("20GB Per Month", 250, "500","Starzplay Recharg Card 250 SAR"))
        StarzplayList.add(StarzplayData("25GB Per Month", 300, "600","Starzplay Recharg Card 300 SAR"))
        StarzplayList.add(StarzplayData("30GB Per Month", 350, "700","Starzplay Recharg Card 350 SAR"))
        StarzplayList.add(StarzplayData("40GB Per Month", 234, "800","Starzplay Recharg Card 400 SAR"))

        starzPlay_rv.adapter = StarzplayAdapter(StarzplayList,this)
        starzPlay_rv.layoutManager = GridLayoutManager(context,2)
        starzPlay_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.starzplay
                ,StarzplayList.get(position).text2
                ,StarzplayList.get(position).text3
                ,StarzplayList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(StarzplayFragmentDirections.actionStarzPlayFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}