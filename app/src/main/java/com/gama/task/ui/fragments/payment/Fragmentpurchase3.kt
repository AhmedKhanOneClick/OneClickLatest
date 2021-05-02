package com.gama.task.ui.fragments.payment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R

class Fragmentpurchase3: Fragment(R.layout.fragment_sucess3) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({


            view?.post {
               findNavController().navigate(Fragmentpurchase3Directions.actionFragmentpurchase3ToSearchPagerFragment())
            }
        }, 1000) // 3000 is the delayed time in milliseconds.
    }
}