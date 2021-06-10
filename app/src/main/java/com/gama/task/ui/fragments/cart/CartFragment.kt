package com.gama.task.ui.fragments.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gama.task.R
import com.gama.task.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment :Fragment(R.layout.fragment_cart),CartAdapter.OnItemClickListener {
    var checkout=0.00
    //var check_deleted=0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iterator = GlobalClass.globalCartList.listIterator()

        for (item in iterator) {

            checkout+=item.Price
        }
        cart_rv.adapter = CartAdapter(this.requireContext(),GlobalClass.globalCartList,this)
        cart_rv.layoutManager = LinearLayoutManager(context)
        cart_rv.setHasFixedSize(true)
        total.text=checkout.toString()
        checkout_btn.setOnClickListener {
          findNavController().navigate(CartFragmentDirections.actionCartFragmentToFragmentcheckout1())

        }
    }

    override fun onClick(position: Int) {


      GlobalClass.globalCartList.removeAt(position)
checkout=0.00
       // val iterator = GlobalClass.globalCartList.listIterator()

        for (item in GlobalClass.globalCartList) {

            checkout+=item.Price
        }
        cart_rv.adapter = CartAdapter(this.requireContext(),GlobalClass.globalCartList,this)
        cart_rv.layoutManager = LinearLayoutManager(context)
        total.text=checkout.toString()
        cart_rv.setHasFixedSize(true)

        (activity as MainActivity).observeCartCounter()
    }




}