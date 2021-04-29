package com.gama.task.ui.fragments.voicedatacharg

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import kotlinx.android.synthetic.main.fragment_voice_recharge.*

class VoiceRechargeFragment : Fragment(R.layout.fragment_voice_recharge) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mobily_btn.setOnClickListener{

            val action=VoiceRechargeFragmentDirections.actionVoiceRechargeFragmentToMobilyFragment()

            findNavController().navigate(action)
        }
//        stc_btn.setOnClickListener {
//            val action=VoiceRechargeFragmentDirections.actionVoiceRechargeFragmentToStcFragment()
//            findNavController().navigate(action)
//        }
//        zain_btn.setOnClickListener {
//            val action=VoiceRechargeFragmentDirections.actionVoiceRechargeFragmentToZainFragment()
//            findNavController().navigate(action)
//        }
//        friendi_btn.setOnClickListener {
//            val action=VoiceRechargeFragmentDirections.actionVoiceRechargeFragmentToFriendFragment()
//             findNavController().navigate(action)
//        }
//        lebara_btn.setOnClickListener{
//            val action=VoiceRechargeFragmentDirections.actionVoiceRechargeFragmentToLebaraFragment()
//            findNavController().navigate(action)
//        }
//        virgin_btn.setOnClickListener {
//
//            val action=VoiceRechargeFragmentDirections.actionVoiceRechargeFragmentToVirginFragment2()
//            findNavController().navigate(action)
//        }
//        go_btn.setOnClickListener {
//            val action=VoiceRechargeFragmentDirections.actionVoiceRechargeFragmentToGoFragment()
//            findNavController().navigate(action)

//        }

    }
}