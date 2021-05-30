package com.gama.task.ui.fragments.giftcards.razorgoldfragment

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
import kotlinx.android.synthetic.main.fragment_gift_card_razorgold.*

class RazorgoldFragment : Fragment(R.layout.fragment_gift_card_razorgold),RazorgoldAdapter.OnItemClickListener {

    val razorgoldList=ArrayList<RazorgoldData>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        razorgoldList.add(RazorgoldData("2GB Per Month", "50".toInt(), "100","Razorgold Recharg Card 50 SAR"))
        razorgoldList.add(RazorgoldData("5GB Per Month", "100".toInt(), "200","Razorgold Recharg Card 100 SAR"))
        razorgoldList.add(RazorgoldData("10GB Per Month", "150".toInt(), "300","Razorgold Recharg Card 150 SAR"))
        razorgoldList.add(RazorgoldData("15GB Per Month", "200".toInt(), "400","Razorgold Recharg Card 200 SAR"))
        razorgoldList.add(RazorgoldData("20GB Per Month", "250".toInt(), "500","Razorgold Recharg Card 250 SAR"))
        razorgoldList.add(RazorgoldData("25GB Per Month", "300".toInt(), "600","Razorgold Recharg Card 300 SAR"))
        razorgoldList.add(RazorgoldData("30GB Per Month", "350".toInt(), "700","Razorgold Recharg Card 350 SAR"))
        razorgoldList.add(RazorgoldData("40GB Per Month", "400".toInt(), "800","NiRazorgoldntendo Recharg Card 400 SAR"))
        razorgold_rv.adapter = RazorgoldAdapter(razorgoldList,this)
        razorgold_rv.layoutManager = GridLayoutManager(context,2)
        razorgold_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.razor_gold
                ,razorgoldList.get(position).text2
                ,razorgoldList.get(position).text3
                ,razorgoldList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(RazorgoldFragmentDirections.actionRazorgoldFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}