package com.gama.task.ui.fragments.drawrmenu

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import com.gama.task.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_menu_setting.*

class SettingFragment:Fragment(R.layout.fragment_menu_setting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sp: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val mEdit1: SharedPreferences.Editor = sp.edit()


        //radio group to check account type
        language_group.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                if (checkedId == R.id.radio_arabic) {
                    (activity as MainActivity).updateLangToAR()

                    mEdit1.apply {
                        putString("lang", "ar")

                    }.apply()
                   //- findNavController().navigate(SettingFragmentDirections.actionAllReceiptFragmentToSettingFragment2())
                } else if (checkedId == R.id.radio_english) {
                    (activity as MainActivity).updateLangToEN()

                    mEdit1.apply {
                        putString("lang", "en")

                    }.apply()
                    //- findNavController().navigate(SettingFragmentDirections.actionAllReceiptFragmentToSettingFragment2())

                } else if (checkedId == R.id.radio_urdo) {
                    (activity as MainActivity).updateLangToUR()
                    mEdit1.apply {
                        putString("lang", "ur")

                    }.apply()
                  //-  findNavController().navigate(SettingFragmentDirections.actionAllReceiptFragmentToSettingFragment2())
                }


            })
    }
}

