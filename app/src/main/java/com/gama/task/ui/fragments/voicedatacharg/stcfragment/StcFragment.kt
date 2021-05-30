package com.gama.task.ui.fragments.voicedatacharg.stcfragment

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
import kotlinx.android.synthetic.main.fragment_data_card_stc.*

class StcFragment : Fragment(R.layout.fragment_data_card_stc),StcAdapter.OnItemClickListener {
    val stcList=ArrayList<StcData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        stcList.add(StcData("10GB for 1 Month", "115".toInt(), "115","Stc Data Recharge Card 115 SAR"))
        stcList.add(StcData("10GB for 2 Months", "173".toInt(), "173","Stc Data Recharge Card 173 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202".toInt(), "202","Stc Data Recharge Card 202 SAR"))
        stcList.add(StcData("50GB for 2 Months", "253".toInt(), "253","Stc Data Recharge Card 253 SAR"))
        stcList.add(StcData("100GB for 3 Months", "403".toInt(), "403","Stc Data Recharge Card 403 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202".toInt(), "202","Stc Data Recharge Card 202 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202".toInt(), "202","Stc Data Recharge Card 202 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202".toInt(), "202","Stc Data Recharge Card 202 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202".toInt(), "202","Stc Data Recharge Card 202 SAR"))

        stc_rv.adapter = StcAdapter(stcList,this)
        stc_rv.layoutManager = GridLayoutManager(context,2)
        stc_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.stc
                ,stcList.get(position).text2
                ,stcList.get(position).text3
                ,stcList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(StcFragmentDirections.actionStcFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}