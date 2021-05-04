package com.gama.task.ui.fragments.voicerecharge.stcfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.card_friendi_item2.view.*
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_voice_card_stc.*

class StcFragment : Fragment(R.layout.fragment_voice_card_stc),StcAdapter.OnItemClickListener {

    val stcList=ArrayList<StcData>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        stcList.add(StcData("Voice Recharge", 19, "20","STC Recharge Card 20 SAR"))
        stcList.add(StcData("Voice Recharge", 22, "23","STC Recharge Card 23 SAR"))
        stcList.add(StcData("Voice Recharge", 28, "28.75","STC Recharge Card 28.75 SAR"))
        stcList.add(StcData("Voice Recharge", 33, "34.50","STC Recharge Card 34.50 SAR"))
        stcList.add(StcData("Voice Recharge", 55, "15","STC Recharge Card 57.50 SAR"))
        stcList.add(StcData("Voice Recharge", 66, "115","STC Recharge Card 115 SAR"))
        stcList.add(StcData("Voice Recharge", 2233, "230","STC Recharge Card 230 SAR"))
        stcList.add(StcData("Voice Recharge", 554, "345","STC Recharge Card 345 SAR"))
        Vstc_rv.adapter = StcAdapter(stcList,this)
        Vstc_rv.layoutManager = GridLayoutManager(context,2)
        Vstc_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.stc
                ,stcList.get(position).text2
                ,stcList.get(position).text3
                ,stcList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(StcFragmentDirections.actionStcvoiceFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}