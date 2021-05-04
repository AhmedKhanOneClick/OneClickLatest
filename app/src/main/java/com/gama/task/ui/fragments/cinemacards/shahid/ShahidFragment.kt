package com.gama.task.ui.fragments.cinemacards.shahid
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_cinema_card_shahid.*

class ShahidFragment:Fragment(R.layout.fragment_cinema_card_shahid),ShahidAdapter.OnItemClickListener {
    val ShahidList=ArrayList<ShahidData>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        ShahidList.add(ShahidData("2GB Per Month", 51, "100","Shahid Recharg Card 50 SAR"))
        ShahidList.add(ShahidData("5GB Per Month", 100, "200","Shahid Recharg Card 100 SAR"))
        ShahidList.add(ShahidData("10GB Per Month", 150, "300","Shahid Recharg Card 150 SAR"))
        ShahidList.add(ShahidData("15GB Per Month", 200, "400","Shahid Recharg Card 200 SAR"))
        ShahidList.add(ShahidData("20GB Per Month", 250, "500","Shahid Recharg Card 250 SAR"))
        ShahidList.add(ShahidData("25GB Per Month", 300, "600","Shahid Recharg Card 300 SAR"))
        ShahidList.add(ShahidData("30GB Per Month", 350, "700","Shahid Recharg Card 350 SAR"))
        ShahidList.add(ShahidData("40GB Per Month", 400, "800","Shahid Recharg Card 400 SAR"))

        shahid_rv.adapter = ShahidAdapter(ShahidList,this)
        shahid_rv.layoutManager = GridLayoutManager(context,2)
        shahid_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.shahid_vip
                ,ShahidList.get(position).text2
                ,ShahidList.get(position).text3
                ,ShahidList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(ShahidFragmentDirections.actionShahidFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}