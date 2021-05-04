package com.gama.task.ui.fragments.voicerecharge.zainfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import com.gama.task.ui.fragments.voicerecharge.stcfragment.StcData
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_voice_card_zain.*

class ZainFragment : Fragment(R.layout.fragment_voice_card_zain),ZainAdapter.OnItemClickListener {
    val zainList=ArrayList<ZainData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        zainList.add(ZainData("2GB Per Month", "50".toInt(), "100","Zain Recharg Card 50 SAR"))
        zainList.add(ZainData("5GB Per Month", "100".toInt(), "200","Zain Recharg Card 100 SAR"))
        zainList.add(ZainData("10GB Per Month", "150".toInt(), "300","Zain Recharg Card 150 SAR"))
        zainList.add(ZainData("15GB Per Month", "200".toInt(), "400","Zain Recharg Card 200 SAR"))
        zainList.add(ZainData("20GB Per Month", "250".toInt(), "500","Zain Recharg Card 250 SAR"))
        zainList.add(ZainData("25GB Per Month", "300".toInt(), "600","Zain Recharg Card 300 SAR"))
        zainList.add(ZainData("30GB Per Month", "350".toInt(), "700","Zain Recharg Card 350 SAR"))
        zainList.add(ZainData("40GB Per Month", "400".toInt(), "800","Zain Recharg Card 400 SAR"))
        Vzain_rv.adapter = ZainAdapter(zainList,this)
        Vzain_rv.layoutManager = GridLayoutManager(context,2)
        Vzain_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.zain
                ,zainList.get(position).text2
                ,zainList.get(position).text3
                ,zainList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(ZainFragmentDirections.actionZainvoiceFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}