package com.gama.task.ui.fragments.giftcards.tmmmtfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*
import kotlinx.android.synthetic.main.fragment_gift_card_tmmmt.*

class TmmmtFragment : Fragment(R.layout.fragment_gift_card_tmmmt) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tmmmtList=ArrayList<TmmmtData>()

        tmmmtList.add(TmmmtData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        tmmmtList.add(TmmmtData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        tmmmtList.add(TmmmtData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        tmmmtList.add(TmmmtData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        tmmmtList.add(TmmmtData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        tmmmtList.add(TmmmtData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        tmmmtList.add(TmmmtData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        tmmmtList.add(TmmmtData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        tmmmt_rv.adapter = TmmmtAdapter(tmmmtList)
        tmmmt_rv.layoutManager = GridLayoutManager(context,2)
        tmmmt_rv.setHasFixedSize(true)

    }
}