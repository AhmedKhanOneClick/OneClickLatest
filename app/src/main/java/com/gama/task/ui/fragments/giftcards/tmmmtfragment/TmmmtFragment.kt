package com.gama.task.ui.fragments.giftcards.tmmmtfragment

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
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*
import kotlinx.android.synthetic.main.fragment_gift_card_tmmmt.*

class TmmmtFragment : Fragment(R.layout.fragment_gift_card_tmmmt),TmmmtAdapter.OnItemClickListener {
    val tmmmtList=ArrayList<TmmmtData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        tmmmtList.add(TmmmtData("2GB Per Month", "50".toInt(), "100","Tmmmt Recharg Card 50 SAR"))
        tmmmtList.add(TmmmtData("5GB Per Month", "100".toInt(), "200","Tmmmt Recharg Card 100 SAR"))
        tmmmtList.add(TmmmtData("10GB Per Month", "150".toInt(), "300","Tmmmt Recharg Card 150 SAR"))
        tmmmtList.add(TmmmtData("15GB Per Month", "200".toInt(), "400","Tmmmt Recharg Card 200 SAR"))
        tmmmtList.add(TmmmtData("20GB Per Month", "250".toInt(), "500","Tmmmt Recharg Card 250 SAR"))
        tmmmtList.add(TmmmtData("25GB Per Month", "300".toInt(), "600","Tmmmt Recharg Card 300 SAR"))
        tmmmtList.add(TmmmtData("30GB Per Month", "350".toInt(), "700","Tmmmt Recharg Card 350 SAR"))
        tmmmtList.add(TmmmtData("40GB Per Month", "400".toInt(), "800","Tmmmt Recharg Card 400 SAR"))
        tmmmt_rv.adapter = TmmmtAdapter(tmmmtList,this)
        tmmmt_rv.layoutManager = GridLayoutManager(context,2)
        tmmmt_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.tmmmt
                ,tmmmtList.get(position).text2
                ,tmmmtList.get(position).text3
                ,tmmmtList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(TmmmtFragmentDirections.actionTmmmtFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}