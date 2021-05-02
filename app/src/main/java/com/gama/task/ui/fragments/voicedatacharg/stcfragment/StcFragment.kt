package com.gama.task.ui.fragments.voicedatacharg.stcfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.fragment_data_card_friendi.*
import kotlinx.android.synthetic.main.fragment_data_card_stc.*

class StcFragment : Fragment(R.layout.fragment_data_card_stc) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val stcList=ArrayList<StcData>()

        stcList.add(StcData("10GB for 1 Month", "115", "115","Data Recharge Card 115 SAR"))
        stcList.add(StcData("10GB for 2 Months", "173", "173","Data Recharge Card 173 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202", "202","Data Recharge Card 202 SAR"))
        stcList.add(StcData("50GB for 2 Months", "253", "253","Data Recharge Card 253 SAR"))
        stcList.add(StcData("100GB for 3 Months", "403", "403","Data Recharge Card 403 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202", "202","Data Recharge Card 202 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202", "202","Data Recharge Card 202 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202", "202","Data Recharge Card 202 SAR"))
        stcList.add(StcData("10GB for 3 Months", "202", "202","Data Recharge Card 202 SAR"))

        stc_rv.adapter = StcAdapter(stcList)
        stc_rv.layoutManager = GridLayoutManager(context,2)
        stc_rv.setHasFixedSize(true)
    }
}