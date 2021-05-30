package com.gama.task.ui.fragments.giftcards.mcafeefragment

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
import kotlinx.android.synthetic.main.fragment_gift_card_mcaffee.*

class McaffeeFragment : Fragment(R.layout.fragment_gift_card_mcaffee),McaffeAdapter.OnItemClickListener {

    val mcaffeeList=ArrayList<McaffeeData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        mcaffeeList.add(McaffeeData("2GB Per Month", "50".toInt(), "100","Mcaffee Recharg Card 50 SAR"))
        mcaffeeList.add(McaffeeData("5GB Per Month", "100".toInt(), "200","Mcaffee Recharg Card 100 SAR"))
        mcaffeeList.add(McaffeeData("10GB Per Month", "150".toInt(), "300","Mcaffee Recharg Card 150 SAR"))
        mcaffeeList.add(McaffeeData("15GB Per Month", "200".toInt(), "400","Mcaffee Recharg Card 200 SAR"))
        mcaffeeList.add(McaffeeData("20GB Per Month", "250".toInt(), "500","Mcaffee Recharg Card 250 SAR"))
        mcaffeeList.add(McaffeeData("25GB Per Month", "300".toInt(), "600","Mcaffee Recharg Card 300 SAR"))
        mcaffeeList.add(McaffeeData("30GB Per Month", "350".toInt(), "700","Mcaffee Recharg Card 350 SAR"))
        mcaffeeList.add(McaffeeData("40GB Per Month", "400".toInt(), "800","Mcaffee Recharg Card 400 SAR"))
        mcaffee_rv.adapter = McaffeAdapter(mcaffeeList,this)
        mcaffee_rv.layoutManager = GridLayoutManager(context,2)
        mcaffee_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.mcafee
                ,mcaffeeList.get(position).text2
                ,mcaffeeList.get(position).text3
                ,mcaffeeList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(McaffeeFragmentDirections.actionMcaffeeFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}