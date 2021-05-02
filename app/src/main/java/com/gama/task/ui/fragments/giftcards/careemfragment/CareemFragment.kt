package com.gama.task.ui.fragments.giftcards.careemfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*

class CareemFragment: Fragment(R.layout.fragment_gift_card_careem) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val careemList=ArrayList<CareemData>()

        careemList.add(CareemData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        careemList.add(CareemData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        careemList.add(CareemData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        careemList.add(CareemData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        careemList.add(CareemData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        careemList.add(CareemData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        careemList.add(CareemData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        careemList.add(CareemData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        careem_rv.adapter = CareemAdapter(careemList)
        careem_rv.layoutManager = GridLayoutManager(context,2)
        careem_rv.setHasFixedSize(true)

    }
}