package com.gama.task.ui.fragments.gamecards.lordsfragment

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
import kotlinx.android.synthetic.main.fragment_game_card_lords.*
import kotlinx.android.synthetic.main.fragment_gift_card_careem.*

class LordsFragment : Fragment(R.layout.fragment_game_card_lords),LordsAdapter.OnItemClickListener {
    val lordsList=ArrayList<LordsData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        lordsList.add(LordsData("2GB Per Month", "50".toInt(), "100","Lords Recharg Card 50 SAR"))
        lordsList.add(LordsData("5GB Per Month", "100".toInt(), "200","Lords Recharg Card 100 SAR"))
        lordsList.add(LordsData("10GB Per Month", "150".toInt(), "300","Lords Recharg Card 150 SAR"))
        lordsList.add(LordsData("15GB Per Month", "200".toInt(), "400","Lords Recharg Card 200 SAR"))
        lordsList.add(LordsData("20GB Per Month", "250".toInt(), "500","Lords Recharg Card 250 SAR"))
        lordsList.add(LordsData("25GB Per Month", "300".toInt(), "600","Lords Recharg Card 300 SAR"))
        lordsList.add(LordsData("30GB Per Month", "350".toInt(), "700","Lords Recharg Card 350 SAR"))
        lordsList.add(LordsData("40GB Per Month", "400".toInt(), "800","Lords Recharg Card 400 SAR"))
        lords_rv.adapter = LordsAdapter(lordsList,this)
        lords_rv.layoutManager = GridLayoutManager(context,2)
        lords_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.lords
                ,lordsList.get(position).text2
                ,lordsList.get(position).text3
                ,lordsList.get(position).text4))
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(LordsFragmentDirections.actionLordsFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}