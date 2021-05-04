package com.gama.task.ui.fragments.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.gamecards.nintendofragment.NintendAdapter
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_game_card_nintend.*

class CartFragment :Fragment(R.layout.fragment_cart),CartAdapter.OnItemClickListener {
    var checkout=0
    //var check_deleted=0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iterator = GlobalClass.globalCartList.listIterator()

        for (item in iterator) {

            checkout+=item.text2
        }
        cart_rv.adapter = CartAdapter(GlobalClass.globalCartList,this)
        cart_rv.layoutManager = LinearLayoutManager(context)
        cart_rv.setHasFixedSize(true)
        total.text=checkout.toString()
        checkout_btn.setOnClickListener {
           findNavController().navigate(CartFragmentDirections.actionCartFragmentToFragmentpurchase1())

        }
    }

    override fun onClick(position: Int) {


      GlobalClass.globalCartList.removeAt(position)
checkout=0
       // val iterator = GlobalClass.globalCartList.listIterator()

        for (item in GlobalClass.globalCartList) {

            checkout+=item.text2
        }
        cart_rv.adapter = CartAdapter(GlobalClass.globalCartList,this)
        cart_rv.layoutManager = LinearLayoutManager(context)
        total.text=checkout.toString()
        cart_rv.setHasFixedSize(true)
    }




}