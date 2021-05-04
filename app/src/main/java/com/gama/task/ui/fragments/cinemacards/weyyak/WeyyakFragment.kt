package com.gama.task.ui.fragments.cinemacards.weyyak
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_cinema_card_weyyak.*

class WeyyakFragment:Fragment(R.layout.fragment_cinema_card_weyyak),WeyyakAdapter.OnItemClickListener {

    val WeyyakList=ArrayList<WeyyakData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        WeyyakList.add(WeyyakData("2GB Per Month", 12, "100","Weyyak Recharg Card 50 SAR"))
        WeyyakList.add(WeyyakData("5GB Per Month", 123, "200","Weyyak Recharg Card 100 SAR"))
        WeyyakList.add(WeyyakData("10GB Per Month", 123, "300","Weyyak Recharg Card 150 SAR"))
        WeyyakList.add(WeyyakData("15GB Per Month", 12, "400","Weyyak Recharg Card 200 SAR"))
        WeyyakList.add(WeyyakData("20GB Per Month", 300, "500","Weyyak Recharg Card 250 SAR"))
        WeyyakList.add(WeyyakData("25GB Per Month", 200, "600","Weyyak Recharg Card 300 SAR"))
        WeyyakList.add(WeyyakData("30GB Per Month", 19, "700","Weyyak Recharg Card 350 SAR"))
        WeyyakList.add(WeyyakData("40GB Per Month", 44, "800","Weyyak Recharg Card 400 SAR"))

        weyyak_rv.adapter = WeyyakAdapter(WeyyakList,this)
        weyyak_rv.layoutManager = GridLayoutManager(context,2)
        weyyak_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.weyyak
                ,WeyyakList.get(position).text2
                ,WeyyakList.get(position).text3
                ,WeyyakList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(WeyyakFragmentDirections.actionWeyyakFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}