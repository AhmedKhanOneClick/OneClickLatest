package com.gama.task.ui.fragments.giftcards.careemfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*

class CareemFragment: Fragment(R.layout.fragment_gift_card_careem),CareemAdapter.OnItemClickListener {
    val careemList=ArrayList<CareemData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        careemList.add(CareemData("2GB Per Month", "50".toInt(), "100","Careem Recharg Card 50 SAR"))
        careemList.add(CareemData("5GB Per Month", "100".toInt(), "200","Careem Recharg Card 100 SAR"))
        careemList.add(CareemData("10GB Per Month", "150".toInt(), "300","Careem Recharg Card 150 SAR"))
        careemList.add(CareemData("15GB Per Month", "200".toInt(), "400","Careem Recharg Card 200 SAR"))
        careemList.add(CareemData("20GB Per Month", "250".toInt(), "500","Careem Recharg Card 250 SAR"))
        careemList.add(CareemData("25GB Per Month", "300".toInt(), "600","Careem Recharg Card 300 SAR"))
        careemList.add(CareemData("30GB Per Month", "350".toInt(), "700","Careem Recharg Card 350 SAR"))
        careemList.add(CareemData("40GB Per Month", "400".toInt(), "800","Careem Recharg Card 400 SAR"))
        careem_rv.adapter = CareemAdapter(careemList,this)
        careem_rv.layoutManager = GridLayoutManager(context,2)
        careem_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.careem
                ,careemList.get(position).text2
                ,careemList.get(position).text3
                ,careemList.get(position).text4))
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(CareemFragmentDirections.actionCareemFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}