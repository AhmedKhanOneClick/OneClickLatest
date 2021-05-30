package com.gama.task.ui.fragments.voicerecharge.mobilyfragment

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
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_voice_card_mobily.*

class MobilyVoiceFragment : Fragment(R.layout.fragment_voice_card_mobily),MobilyVoiceAdapter.OnItemClickListener {

    val mobilyList=ArrayList<MobilyVoiceData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mobilyList.add(MobilyVoiceData("2GB Per Month", "50".toInt(), "100","Mobily Recharg Card 50 SAR"))
        mobilyList.add(MobilyVoiceData("5GB Per Month", "100".toInt(), "200","Mobily Recharg Card 100 SAR"))
        mobilyList.add(MobilyVoiceData("10GB Per Month", "150".toInt(), "300","Mobily Recharg Card 150 SAR"))
        mobilyList.add(MobilyVoiceData("15GB Per Month", "200".toInt(), "400","Mobily Recharg Card 200 SAR"))
        mobilyList.add(MobilyVoiceData("20GB Per Month", "250".toInt(), "500","Mobily Recharg Card 250 SAR"))
        mobilyList.add(MobilyVoiceData("25GB Per Month", "300".toInt(), "600","Mobily Recharg Card 300 SAR"))
        mobilyList.add(MobilyVoiceData("30GB Per Month", "350".toInt(), "700","Mobily Recharg Card 350 SAR"))
        mobilyList.add(MobilyVoiceData("40GB Per Month", "400".toInt(), "800","Mobily Recharg Card 400 SAR"))
        Vmobily_rv.adapter = MobilyVoiceAdapter(mobilyList,this)
        Vmobily_rv.layoutManager = GridLayoutManager(context,2)
        Vmobily_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.mobily
                ,mobilyList.get(position).text2
                ,mobilyList.get(position).text3
                ,mobilyList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(MobilyVoiceFragmentDirections.actionMobilyvoiceFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}