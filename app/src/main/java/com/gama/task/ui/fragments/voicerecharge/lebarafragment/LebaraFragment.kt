package com.gama.task.ui.fragments.voicerecharge.lebarafragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.voicerecharge.lebarafragment.LebaraAdapter
import com.gama.task.ui.fragments.voicerecharge.lebarafragment.LebaraData
import kotlinx.android.synthetic.main.fragment_voice_card_lebara.*

class LebaraFragment : Fragment(R.layout.fragment_voice_card_lebara),LebaraAdapter.OnItemClickListener {
    val lebaraList=ArrayList<LebaraData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        lebaraList.add(LebaraData("2GB Per Month", "50".toInt(), "100","Lebara Recharg Card 50 SAR"))
        lebaraList.add(LebaraData("5GB Per Month", "100".toInt(), "200","Lebara Recharg Card 100 SAR"))
        lebaraList.add(LebaraData("10GB Per Month", "150".toInt(), "300","Lebara Recharg Card 150 SAR"))
        lebaraList.add(LebaraData("15GB Per Month", "200".toInt(), "400","Lebara Recharg Card 200 SAR"))
        lebaraList.add(LebaraData("20GB Per Month", "250".toInt(), "500","Lebara Recharg Card 250 SAR"))
        lebaraList.add(LebaraData("25GB Per Month", "300".toInt(), "600","Lebara Recharg Card 300 SAR"))
        lebaraList.add(LebaraData("30GB Per Month", "350".toInt(), "700","Lebara Recharg Card 350 SAR"))
        lebaraList.add(LebaraData("40GB Per Month", "400".toInt(), "800","Lebara Recharg Card 400 SAR"))
        Vlebara_rv.adapter = LebaraAdapter(lebaraList,this)
        Vlebara_rv.layoutManager = GridLayoutManager(context,2)
        Vlebara_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.lebara
                ,lebaraList.get(position).text2
                ,lebaraList.get(position).text3
                ,lebaraList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(LebaraFragmentDirections.actionLebaravoiceFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}