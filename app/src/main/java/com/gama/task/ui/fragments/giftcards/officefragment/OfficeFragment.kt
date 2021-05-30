package com.gama.task.ui.fragments.giftcards.officefragment

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
import kotlinx.android.synthetic.main.fragment_gift_card_office.*

class OfficeFragment : Fragment(R.layout.fragment_gift_card_office),OfficeAdapter.OnItemClickListener {
    val officeList=ArrayList<OfficeData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        officeList.add(OfficeData("2GB Per Month", "50".toInt(), "100","Office Recharg Card 50 SAR"))
        officeList.add(OfficeData("5GB Per Month", "100".toInt(), "200","Office Recharg Card 100 SAR"))
        officeList.add(OfficeData("10GB Per Month", "150".toInt(), "300","Office Recharg Card 150 SAR"))
        officeList.add(OfficeData("15GB Per Month", "200".toInt(), "400","Office Recharg Card 200 SAR"))
        officeList.add(OfficeData("20GB Per Month", "250".toInt(), "500","Office Recharg Card 250 SAR"))
        officeList.add(OfficeData("25GB Per Month", "300".toInt(), "600","Office Recharg Card 300 SAR"))
        officeList.add(OfficeData("30GB Per Month", "350".toInt(), "700","Office Recharg Card 350 SAR"))
        officeList.add(OfficeData("40GB Per Month", "400".toInt(), "800","Office Recharg Card 400 SAR"))
        office_rv.adapter = OfficeAdapter(officeList,this)
        office_rv.layoutManager = GridLayoutManager(context,2)
        office_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {

        GlobalClass.globalCartList.add(
            CartItem(R.drawable.office
                ,officeList.get(position).text2
                ,officeList.get(position).text3
                ,officeList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(OfficeFragmentDirections.actionOfficeFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}