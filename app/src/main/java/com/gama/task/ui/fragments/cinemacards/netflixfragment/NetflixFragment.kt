package com.gama.task.ui.fragments.cinemacards.netflixfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_cinema_card_netflix.*


//class StarzplayFragment {
//}
class NetflixFragment: Fragment(R.layout.fragment_cinema_card_netflix),NetflixAdapter.OnItemClickListener{

    val NetflixList=ArrayList<NetflixData>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        NetflixList.add(NetflixData("2GB Per Month", 51, "100","Netflix Recharg Card 50 SAR"))
        NetflixList.add(NetflixData("5GB Per Month", 100, "200","Netflix Recharg Card 100 SAR"))
        NetflixList.add(NetflixData("10GB Per Month", 150, "300","Netflix Recharg Card 150 SAR"))
        NetflixList.add(NetflixData("15GB Per Month", 200, "400","Netflix Recharg Card 200 SAR"))
        NetflixList.add(NetflixData("20GB Per Month", 250, "500","Netflix Recharg Card 250 SAR"))
        NetflixList.add(NetflixData("25GB Per Month", 300, "600","Netflix Recharg Card 300 SAR"))
        NetflixList.add(NetflixData("30GB Per Month", 350, "700","Netflix Recharg Card 350 SAR"))
        NetflixList.add(NetflixData("40GB Per Month", 400, "800","Netflix Recharg Card 400 SAR"))

        netflix_rv.adapter = NetflixAdapter(NetflixList,this)
        netflix_rv.layoutManager = GridLayoutManager(context,2)
        netflix_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {

        GlobalClass.globalCartList.add(
            CartItem(R.drawable.netflix
                ,NetflixList.get(position).text2
                ,NetflixList.get(position).text3
                ,NetflixList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(NetflixFragmentDirections.actionNetflixFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}