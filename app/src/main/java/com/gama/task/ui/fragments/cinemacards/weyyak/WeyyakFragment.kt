package com.gama.task.ui.fragments.cinemacards.weyyak
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_cinema_card_weyyak.*

class WeyyakFragment:Fragment(R.layout.fragment_cinema_card_weyyak) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val WeyyakList=ArrayList<WeyyakData>()

        WeyyakList.add(WeyyakData("2GB Per Month", "51", "100","XBox Recharg Card 50 SAR"))
        WeyyakList.add(WeyyakData("5GB Per Month", "100", "200","XBox Recharg Card 100 SAR"))
        WeyyakList.add(WeyyakData("10GB Per Month", "150", "300","XBox Recharg Card 150 SAR"))
        WeyyakList.add(WeyyakData("15GB Per Month", "200", "400","XBox Recharg Card 200 SAR"))
        WeyyakList.add(WeyyakData("20GB Per Month", "250", "500","XBox Recharg Card 250 SAR"))
        WeyyakList.add(WeyyakData("25GB Per Month", "300", "600","XBox Recharg Card 300 SAR"))
        WeyyakList.add(WeyyakData("30GB Per Month", "350", "700","XBox Recharg Card 350 SAR"))
        WeyyakList.add(WeyyakData("40GB Per Month", "400", "800","XBox Recharg Card 400 SAR"))

        weyyak_rv.adapter = WeyyakAdapter(WeyyakList)
        weyyak_rv.layoutManager = GridLayoutManager(context,2)
        weyyak_rv.setHasFixedSize(true)
    }
}