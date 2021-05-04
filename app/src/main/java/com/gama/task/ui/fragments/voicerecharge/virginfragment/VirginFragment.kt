package com.gama.task.ui.fragments.voicerecharge.virginfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.voicerecharge.virginfragment.VirginAdapter
import com.gama.task.ui.fragments.voicerecharge.virginfragment.VirginData
import kotlinx.android.synthetic.main.fragment_voice_card_virgin.*

class VirginFragment : Fragment(R.layout.fragment_voice_card_virgin),VirginAdapter.OnItemClickListener {

    val virginList=ArrayList<VirginData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        virginList.add(VirginData("2GB Per Month", "50".toInt(), "100","Virgin Recharg Card 50 SAR"))
        virginList.add(VirginData("5GB Per Month", "100".toInt(), "200","Virgin Recharg Card 100 SAR"))
        virginList.add(VirginData("10GB Per Month", "150".toInt(), "300","Virgin Recharg Card 150 SAR"))
        virginList.add(VirginData("15GB Per Month", "200".toInt(), "400","Virgin Recharg Card 200 SAR"))
        virginList.add(VirginData("20GB Per Month", "250".toInt(), "500","Virgin Recharg Card 250 SAR"))
        virginList.add(VirginData("25GB Per Month", "300".toInt(), "600","Virgin Recharg Card 300 SAR"))
        virginList.add(VirginData("30GB Per Month", "350".toInt(), "700","Virgin Recharg Card 350 SAR"))
        virginList.add(VirginData("40GB Per Month", "400".toInt(), "800","Virgin Recharg Card 400 SAR"))
        Vvirgin_rv.adapter = VirginAdapter(virginList,this)
        Vvirgin_rv.layoutManager = GridLayoutManager(context,2)
        Vvirgin_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.virgini
                ,virginList.get(position).text2
                ,virginList.get(position).text3
                ,virginList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(VirginFragmentDirections.actionVirginvoiceFragmentToBottomSheetCheckOut())

    }

    override fun onLongClick(position: Int) {

    }
}