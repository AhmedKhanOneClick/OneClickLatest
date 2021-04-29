package com.gama.task.ui.fragments.cinemacards.starzplayfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_cinema_card_starzplay.*


//class StarzplayFragment {
//}
class StarzplayFragment: Fragment(R.layout.fragment_cinema_card_starzplay){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val StarzplayList=ArrayList<StarzplayData>()

        StarzplayList.add(StarzplayData("2GB Per Month", "51", "100","XBox Recharg Card 50 SAR"))
        StarzplayList.add(StarzplayData("5GB Per Month", "100", "200","XBox Recharg Card 100 SAR"))
        StarzplayList.add(StarzplayData("10GB Per Month", "150", "300","XBox Recharg Card 150 SAR"))
        StarzplayList.add(StarzplayData("15GB Per Month", "200", "400","XBox Recharg Card 200 SAR"))
        StarzplayList.add(StarzplayData("20GB Per Month", "250", "500","XBox Recharg Card 250 SAR"))
        StarzplayList.add(StarzplayData("25GB Per Month", "300", "600","XBox Recharg Card 300 SAR"))
        StarzplayList.add(StarzplayData("30GB Per Month", "350", "700","XBox Recharg Card 350 SAR"))
        StarzplayList.add(StarzplayData("40GB Per Month", "400", "800","XBox Recharg Card 400 SAR"))

        starzPlay_rv.adapter = StarzplayAdapter(StarzplayList)
        starzPlay_rv.layoutManager = GridLayoutManager(context,2)
        starzPlay_rv.setHasFixedSize(true)
    }
}