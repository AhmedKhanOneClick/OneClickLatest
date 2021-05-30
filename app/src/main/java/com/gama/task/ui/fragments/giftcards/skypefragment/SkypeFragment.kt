package com.gama.task.ui.fragments.giftcards.skypefragment

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
import kotlinx.android.synthetic.main.fragment_gift_card_skype.*

class SkypeFragment : Fragment(R.layout.fragment_gift_card_skype),SkypeAdapter.OnItemClickListener {

    val skypeList=ArrayList<SkypeData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        skypeList.add(SkypeData("2GB Per Month", "50".toInt(), "100","Skype Recharg Card 50 SAR"))
        skypeList.add(SkypeData("5GB Per Month", "100".toInt(), "200","Skype Recharg Card 100 SAR"))
        skypeList.add(SkypeData("10GB Per Month", "150".toInt(), "300","Skype Recharg Card 150 SAR"))
        skypeList.add(SkypeData("15GB Per Month", "200".toInt(), "400","Skype Recharg Card 200 SAR"))
        skypeList.add(SkypeData("20GB Per Month", "250".toInt(), "500","Skype Recharg Card 250 SAR"))
        skypeList.add(SkypeData("25GB Per Month", "300".toInt(), "600","Skype Recharg Card 300 SAR"))
        skypeList.add(SkypeData("30GB Per Month", "350".toInt(), "700","Skype Recharg Card 350 SAR"))
        skypeList.add(SkypeData("40GB Per Month", "400".toInt(), "800","Skype Recharg Card 400 SAR"))
        skype_rv.adapter = SkypeAdapter(skypeList,this)
        skype_rv.layoutManager = GridLayoutManager(context,2)
        skype_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.skype
                ,skypeList.get(position).text2
                ,skypeList.get(position).text3
                ,skypeList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(SkypeFragmentDirections.actionSkypeFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {
    }
}