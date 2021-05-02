package com.gama.task.ui.fragments.giftcards.windowsfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_gift_card_windows.*

class WindowsFragment : Fragment(R.layout.fragment_gift_card_windows) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val windowsList=ArrayList<WindowsData>()

        windowsList.add(WindowsData("2GB Per Month", "50", "100","Nintendo Recharg Card 50 SAR"))
        windowsList.add(WindowsData("5GB Per Month", "100", "200","Nintendo Recharg Card 100 SAR"))
        windowsList.add(WindowsData("10GB Per Month", "150", "300","Nintendo Recharg Card 150 SAR"))
        windowsList.add(WindowsData("15GB Per Month", "200", "400","Nintendo Recharg Card 200 SAR"))
        windowsList.add(WindowsData("20GB Per Month", "250", "500","Nintendo Recharg Card 250 SAR"))
        windowsList.add(WindowsData("25GB Per Month", "300", "600","Nintendo Recharg Card 300 SAR"))
        windowsList.add(WindowsData("30GB Per Month", "350", "700","Nintendo Recharg Card 350 SAR"))
        windowsList.add(WindowsData("40GB Per Month", "400", "800","Nintendo Recharg Card 400 SAR"))
        windows_rv.adapter = WindowsAdapter(windowsList)
        windows_rv.layoutManager = GridLayoutManager(context,2)
        windows_rv.setHasFixedSize(true)

    }
}