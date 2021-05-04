package com.gama.task.ui.fragments.giftcards.noonfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_gift_card_noon.*

class NoonFragment : Fragment(R.layout.fragment_gift_card_noon),NoonAdapter.OnItemClickListener {
    val noonList=ArrayList<NoonData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        noonList.add(NoonData("2GB Per Month", "50".toInt(), "100","noon Recharg Card 50 SAR"))
        noonList.add(NoonData("5GB Per Month", "100".toInt(), "200","noon Recharg Card 100 SAR"))
        noonList.add(NoonData("10GB Per Month", "150".toInt(), "300","noon Recharg Card 150 SAR"))
        noonList.add(NoonData("15GB Per Month", "200".toInt(), "400","noon Recharg Card 200 SAR"))
        noonList.add(NoonData("20GB Per Month", "250".toInt(), "500","noon Recharg Card 250 SAR"))
        noonList.add(NoonData("25GB Per Month", "300".toInt(), "600","noon Recharg Card 300 SAR"))
        noonList.add(NoonData("30GB Per Month", "350".toInt(), "700","noon Recharg Card 350 SAR"))
        noonList.add(NoonData("40GB Per Month", "400".toInt(), "800","noon Recharg Card 400 SAR"))
        noon_rv.adapter = NoonAdapter(noonList,this)
        noon_rv.layoutManager = GridLayoutManager(context,2)
        noon_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.noon
                ,noonList.get(position).text2
                ,noonList.get(position).text3
                ,noonList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(NoonFragmentDirections.actionNoonFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}