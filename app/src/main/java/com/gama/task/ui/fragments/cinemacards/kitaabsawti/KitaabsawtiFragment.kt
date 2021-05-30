package com.gama.task.ui.fragments.cinemacards.kitaabsawti
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
import com.gama.task.ui.fragments.cart.models.CartItem
import com.gama.task.ui.fragments.gamecards.xboxfragment.XboxAdapter
import com.gama.task.ui.fragments.gamecards.xboxfragment.XboxData
import com.gama.task.ui.fragments.gamecards.xboxfragment.XboxFragmentDirections
import kotlinx.android.synthetic.main.fragment_cinema_card_kitaabsawti.*
import kotlinx.android.synthetic.main.fragment_game_card_xbox.*

class KitaabsawtiFragment:Fragment(R.layout.fragment_cinema_card_kitaabsawti),KitaabsawtiAdapter.OnItemClickListener {
    val KitaabsawtiList=ArrayList<KitaabsawtiData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        KitaabsawtiList.add(KitaabsawtiData("2GB Per Month", 50, "100","Kitaabsawti Recharg Card 50 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("5GB Per Month", 100, "200","Kitaabsawti Recharg Card 100 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("10GB Per Month", 150, "300","Kitaabsawti Recharg Card 150 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("15GB Per Month", 200, "400","Kitaabsawti Recharg Card 200 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("20GB Per Month", 250, "500","Kitaabsawti Recharg Card 250 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("25GB Per Month", 300, "600","Kitaabsawti Recharg Card 300 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("30GB Per Month", 350, "700","Kitaabsawti Recharg Card 350 SAR"))
        KitaabsawtiList.add(KitaabsawtiData("40GB Per Month", 400, "800","Kitaabsawti Recharg Card 400 SAR"))

        kitaabsawti_rv.adapter = KitaabsawtiAdapter(KitaabsawtiList,this)
        kitaabsawti_rv.layoutManager = GridLayoutManager(context,2)
        kitaabsawti_rv.setHasFixedSize(true)





    }

    override fun onClick(position: Int) {
        GlobalClass.globalCartList.add(
            CartItem(R.drawable.kitaab_sawti
                ,KitaabsawtiList.get(position).text2
                ,KitaabsawtiList.get(position).text3
                ,KitaabsawtiList.get(position).text4))

        if (!GlobalClass.globalCartList.isEmpty())
            findNavController().navigate(KitaabsawtiFragmentDirections.actionKitaabsawtiFragmentToBottomSheetCheckOut())

    }

    override fun onLongClick(position: Int) {

    }


}