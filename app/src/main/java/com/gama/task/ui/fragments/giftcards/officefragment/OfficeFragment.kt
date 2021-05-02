package com.gama.task.ui.fragments.giftcards.officefragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*
import kotlinx.android.synthetic.main.fragment_gift_card_office.*

class OfficeFragment : Fragment(R.layout.fragment_gift_card_office) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val officeList=ArrayList<OfficeData>()

        officeList.add(OfficeData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        officeList.add(OfficeData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        officeList.add(OfficeData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        officeList.add(OfficeData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        officeList.add(OfficeData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        officeList.add(OfficeData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        officeList.add(OfficeData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        officeList.add(OfficeData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        office_rv.adapter = OfficeAdapter(officeList)
        office_rv.layoutManager = GridLayoutManager(context,2)
        office_rv.setHasFixedSize(true)
    }
}