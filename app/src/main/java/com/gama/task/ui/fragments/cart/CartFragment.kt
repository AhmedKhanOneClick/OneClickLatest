package com.gama.task.ui.fragments.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gama.task.R
import com.gama.task.ui.fragments.gamecards.nintendofragment.NintendAdapter
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_game_card_nintend.*

class CartFragment :Fragment(R.layout.fragment_cart),CartAdapter.OnItemClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cart_rv.adapter = CartAdapter(GlobalClass.globalCartList,this)
        cart_rv.layoutManager = LinearLayoutManager(context)
        cart_rv.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
      GlobalClass.globalCartList.removeAt(position)
        cart_rv.adapter = CartAdapter(GlobalClass.globalCartList,this)
        cart_rv.layoutManager = LinearLayoutManager(context)
        cart_rv.setHasFixedSize(true)
    }
}