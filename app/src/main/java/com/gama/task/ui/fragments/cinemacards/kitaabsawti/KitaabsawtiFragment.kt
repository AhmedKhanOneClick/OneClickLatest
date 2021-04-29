package com.gama.task.ui.fragments.cinemacards.kitaabsawti
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_cinema_card_kitaabsawti.*

class KitaabsawtiFragment:Fragment(R.layout.fragment_cinema_card_kitaabsawti) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val KitaabsawtiList=ArrayList<KitaabsawtiData>()

        KitaabsawtiList.add(KitaabsawtiData("2GB Per Month", "51", "100","XBox Recharg Card 50 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("5GB Per Month", "100", "200","XBox Recharg Card 100 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("10GB Per Month", "150", "300","XBox Recharg Card 150 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("15GB Per Month", "200", "400","XBox Recharg Card 200 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("20GB Per Month", "250", "500","XBox Recharg Card 250 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("25GB Per Month", "300", "600","XBox Recharg Card 300 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("30GB Per Month", "350", "700","XBox Recharg Card 350 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("40GB Per Month", "400", "800","XBox Recharg Card 400 SAR"))

        kitaabsawti_rv.adapter = KitaabsawtiAdapter(KitaabsawtiList)
        kitaabsawti_rv.layoutManager = GridLayoutManager(context,2)
        kitaabsawti_rv.setHasFixedSize(true)
    }
}