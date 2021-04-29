package com.gama.task.ui.fragments.cinemacards.shahid
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_cinema_card_shahid.*

class ShahidFragment:Fragment(R.layout.fragment_cinema_card_shahid) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val ShahidList=ArrayList<ShahidData>()

        ShahidList.add(ShahidData("2GB Per Month", "51", "100","XBox Recharg Card 50 SAR"))
        ShahidList.add(ShahidData("5GB Per Month", "100", "200","XBox Recharg Card 100 SAR"))
        ShahidList.add(ShahidData("10GB Per Month", "150", "300","XBox Recharg Card 150 SAR"))
        ShahidList.add(ShahidData("15GB Per Month", "200", "400","XBox Recharg Card 200 SAR"))
        ShahidList.add(ShahidData("20GB Per Month", "250", "500","XBox Recharg Card 250 SAR"))
        ShahidList.add(ShahidData("25GB Per Month", "300", "600","XBox Recharg Card 300 SAR"))
        ShahidList.add(ShahidData("30GB Per Month", "350", "700","XBox Recharg Card 350 SAR"))
        ShahidList.add(ShahidData("40GB Per Month", "400", "800","XBox Recharg Card 400 SAR"))

        shahid_rv.adapter = ShahidAdapter(ShahidList)
        shahid_rv.layoutManager = GridLayoutManager(context,2)
        shahid_rv.setHasFixedSize(true)
    }
}