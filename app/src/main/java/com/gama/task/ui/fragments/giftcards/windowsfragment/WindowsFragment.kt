package com.gama.task.ui.fragments.giftcards.windowsfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.fragment_gift_card_windows.*

class WindowsFragment : Fragment(R.layout.fragment_gift_card_windows),WindowsAdapter.OnItemClickListener {
    val windowsList=ArrayList<WindowsData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        windowsList.add(WindowsData("2GB Per Month", "50".toInt(), "100","Windows Recharg Card 50 SAR"))
        windowsList.add(WindowsData("5GB Per Month", "100".toInt(), "200","Windows Recharg Card 100 SAR"))
        windowsList.add(WindowsData("10GB Per Month", "150".toInt(), "300","Windows Recharg Card 150 SAR"))
        windowsList.add(WindowsData("15GB Per Month", "200".toInt(), "400","Windows Recharg Card 200 SAR"))
        windowsList.add(WindowsData("20GB Per Month", "250".toInt(), "500","Windows Recharg Card 250 SAR"))
        windowsList.add(WindowsData("25GB Per Month", "300".toInt(), "600","Windows Recharg Card 300 SAR"))
        windowsList.add(WindowsData("30GB Per Month", "350".toInt(), "700","Windows Recharg Card 350 SAR"))
        windowsList.add(WindowsData("40GB Per Month", "400".toInt(), "800","Windows Recharg Card 400 SAR"))
        windows_rv.adapter = WindowsAdapter(windowsList,this)
        windows_rv.layoutManager = GridLayoutManager(context,2)
        windows_rv.setHasFixedSize(true)

    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.windows
                ,windowsList.get(position).text2
                ,windowsList.get(position).text3
                ,windowsList.get(position).text4)
        )
        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(WindowsFragmentDirections.actionWindowsFragmentToBottomSheetCheckOut())
    }

    override fun onLongClick(position: Int) {

    }
}