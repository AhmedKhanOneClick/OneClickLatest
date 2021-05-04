package com.gama.task.ui.fragments.voicedatacharg.mobilyfragment

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
import kotlinx.android.synthetic.main.fragment_data_card_mobily.*

class MobilyFragment : Fragment(R.layout.fragment_data_card_mobily),MobilyAdapter.OnItemClickListener {
    val mobilyList=ArrayList<MobilyData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        mobilyList.add(MobilyData("2GB for 1 Month", "65".toInt(), "65","Mobily Data Card 65 SAR"))
        mobilyList.add(MobilyData("5GB for 1 Month", "90".toInt(), "90","Mobily Data Card 90 SAR"))
        mobilyList.add(MobilyData("10GB for 1 Month", "109.25".toInt(), "109.25","Mobily Data Card 109.25 SAR"))
        mobilyList.add(MobilyData("10GB for 3 Month", "200".toInt(), "200","Mobily Data Card 200 SAR"))
        mobilyList.add(MobilyData("20GB for 3 Month", "260".toInt(), "260","Mobily Data Card 260 SAR"))
        mobilyList.add(MobilyData("50GB for 3 Month", "310".toInt(), "310","Mobily Data Card 310 SAR"))
        mobilyList.add(MobilyData("100GB for 3 Month", "375".toInt(), "375","Mobily Data Card 375 SAR"))
        mobilyList.add(MobilyData("300GB for 3 Month", "525".toInt(), "525","Mobily Data Card 525 SAR"))
        mobily_rv.adapter = MobilyAdapter(mobilyList,this)
        mobily_rv.layoutManager = GridLayoutManager(context,2)
        mobily_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.mobily
                ,mobilyList.get(position).text2
                ,mobilyList.get(position).text3
                ,mobilyList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(MobilyFragmentDirections.actionMobilyFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}