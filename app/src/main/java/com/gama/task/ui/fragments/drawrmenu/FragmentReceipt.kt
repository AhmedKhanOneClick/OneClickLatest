package com.gama.task.ui.fragments.drawrmenu

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import com.gama.task.ui.fragments.cart.GlobalClass
//- import com.gama.task.ui.fragments.payment.Fragmentpurchase3Directions
import com.gama.task.ui.main.MainActivity

class FragmentReceipt :Fragment(R.layout.fragment_receipt){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

          GlobalClass.globalCartList.clear()
        (activity as MainActivity).observeCartCounter()

        Handler().postDelayed({


            view?.post {
                //findNavController().navigate(Fragmentpurchase3Directions.())

                //- findNavController().navigate(FragmentReceiptDirections.actionFragmentReceiptToSearchPagerFragment())

                // findNavController().navigate(Fragmentpurchase3Directions.actionFragmentpurchase3ToFsearchPagerFragment())
            }
        }, 5000) // 3000 is the delayed time in milliseconds.
    }
    }
