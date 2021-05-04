package com.gama.task.ui.fragments.giftcards.itunefragment

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
import kotlinx.android.synthetic.main.fragment_gift_card_itunes.*

class ItuneFragment : Fragment(R.layout.fragment_gift_card_itunes),ItuneAdapter.OnItemClickListener {
    val itunesList=ArrayList<ItuneData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        itunesList.add(ItuneData("2GB Per Month", "50".toInt(), "100","Itune Recharg Card 50 SAR"))
        itunesList.add(ItuneData("5GB Per Month", "100".toInt(), "200","Itune Recharg Card 100 SAR"))
        itunesList.add(ItuneData("10GB Per Month", "150".toInt(), "300","Itune Recharg Card 150 SAR"))
        itunesList.add(ItuneData("15GB Per Month", "200".toInt(), "400","Itune Recharg Card 200 SAR"))
        itunesList.add(ItuneData("20GB Per Month", "250".toInt(), "500","Itune Recharg Card 250 SAR"))
        itunesList.add(ItuneData("25GB Per Month", "300".toInt(), "600","Itune Recharg Card 300 SAR"))
        itunesList.add(ItuneData("30GB Per Month", "350".toInt(), "700","Itune Recharg Card 350 SAR"))
        itunesList.add(ItuneData("40GB Per Month", "400".toInt(), "800","Itune Recharg Card 400 SAR"))
        itunes_rv.adapter = ItuneAdapter(itunesList,this)
        itunes_rv.layoutManager = GridLayoutManager(context,2)
        itunes_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {

        GlobalClass.globalCartList.add(
            CartItem(R.drawable.vip_jalsaat
                ,itunesList.get(position).text2
                ,itunesList.get(position).text3
                ,itunesList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(ItuneFragmentDirections.actionItuneFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}