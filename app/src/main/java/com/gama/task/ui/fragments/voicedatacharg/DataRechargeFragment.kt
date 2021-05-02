package com.gama.task.ui.fragments.voicedatacharg

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_data_recharge.*



class DataRechargeFragment : Fragment(R.layout.fragment_data_recharge) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mobily_card.setOnClickListener{
            val action=
                DataRechargeFragmentDirections.actionDataRechargeFragmentToMobilyFragment()
            findNavController().navigate(action)
        }
        stc_card.setOnClickListener {
            val action=
                DataRechargeFragmentDirections.actionDataRechargeFragmentToStcFragment()
            findNavController().navigate(action)
        }
//        zain_card.setOnClickListener {
//            val action=
//                DataRechargeFragmentDirections.actionDataRechargeFragmentToZainFragment();
//            findNavController().navigate(action)
//        }
//        friend_card.setOnClickListener {
//            val action=
//                DataRechargeFragmentDirections.actionDataRechargeFragmentToFriendFragment();
//            findNavController().navigate(action)
//        }
//        lebara_card.setOnClickListener{
//            val action=
//                DataRechargeFragmentDirections.actionDataRechargeFragmentToLebaraFragment();
//            findNavController().navigate(action)
//        }
//        virgin_card.setOnClickListener {
//            val action=
//                DataRechargeFragmentDirections.actionDataRechargeFragmentToVirginFragment();
//            findNavController().navigate(action)
//        }

    }
}