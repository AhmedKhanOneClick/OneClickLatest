package com.gama.task.ui.fragments.giftcards.mrsoolfragment

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
import kotlinx.android.synthetic.main.fragment_gift_card_mrsool.*

class MrsoolFragment : Fragment(R.layout.fragment_gift_card_mrsool),MrsoolAdapter.OnItemClickListener {

    val mrsoolList=ArrayList<MrsoolData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        mrsoolList.add(MrsoolData("2GB Per Month", "50".toInt(), "100","Mrsool Recharg Card 50 SAR"))
        mrsoolList.add(MrsoolData("5GB Per Month", "100".toInt(), "200","Mrsool Recharg Card 100 SAR"))
        mrsoolList.add(MrsoolData("10GB Per Month", "150".toInt(), "300","Mrsool Recharg Card 150 SAR"))
        mrsoolList.add(MrsoolData("15GB Per Month", "200".toInt(), "400","Mrsool Recharg Card 200 SAR"))
        mrsoolList.add(MrsoolData("20GB Per Month", "250".toInt(), "500","Mrsool Recharg Card 250 SAR"))
        mrsoolList.add(MrsoolData("25GB Per Month", "300".toInt(), "600","Mrsool Recharg Card 300 SAR"))
        mrsoolList.add(MrsoolData("30GB Per Month", "350".toInt(), "700","Mrsool Recharg Card 350 SAR"))
        mrsoolList.add(MrsoolData("40GB Per Month", "400".toInt(), "800","Mrsool Recharg Card 400 SAR"))
        mrsool_rv.adapter = MrsoolAdapter(mrsoolList,this)
        mrsool_rv.layoutManager = GridLayoutManager(context,2)
        mrsool_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.vip_jalsaat
                ,mrsoolList.get(position).text2
                ,mrsoolList.get(position).text3
                ,mrsoolList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(MrsoolFragmentDirections.actionMrsoolFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}