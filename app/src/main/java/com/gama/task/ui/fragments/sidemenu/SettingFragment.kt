package com.gama.task.ui.fragments.sidemenu

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gama.task.R
import com.gama.task.ui.fragments.sidemenu.Map.MainMapActivity
import com.gama.task.ui.fragments.sidemenu.Map.MapsActivity
import com.gama.task.ui.main.MainActivity
import com.gama.task.util.extensions.openActivity
import kotlinx.android.synthetic.main.fragment_menu_setting.*

class SettingFragment:Fragment(R.layout.fragment_menu_setting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferencesmap: SharedPreferences = requireActivity().getSharedPreferences("map", Context.MODE_PRIVATE)
        val prefsEditor = sharedPreferencesmap.edit()
        val serializedObject: String = sharedPreferencesmap.getString("latitude", "")!!
        if(serializedObject.isNotBlank()){
            val name:String = sharedPreferencesmap.getString("name","")!!
            address.setText(name)
        }

        val sp: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val mEdit1: SharedPreferences.Editor = sp.edit()

        var lang=sp.getString("lang",null)
        if (lang.equals("ar")){
            language_group.check(R.id.radio_arabic)
        }
        if (lang.equals("ur")){
            language_group.check(R.id.radio_urdo)
        }
        if (lang.equals("en")){
            language_group.check(R.id.radio_english)
        }

        //radio group to check account type
        language_group.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { group, checkedId ->
                if (checkedId == R.id.radio_arabic) {
                    (activity as MainActivity).updateLangToAR()

                    mEdit1.apply {
                        putString("lang", "ar")

                    }.apply()
                    findNavController().navigate(SettingFragmentDirections.actionSettingFragmentToSettingFragment())
                } else if (checkedId == R.id.radio_english) {
                    (activity as MainActivity).updateLangToEN()

                    mEdit1.apply {
                        putString("lang", "en")

                    }.apply()
                    findNavController().navigate(SettingFragmentDirections.actionSettingFragmentToSettingFragment())

                } else if (checkedId == R.id.radio_urdo) {
                    (activity as MainActivity).updateLangToUR()
                    mEdit1.apply {
                        putString("lang", "ur")

                    }.apply()
                    findNavController().navigate(SettingFragmentDirections.actionSettingFragmentToSettingFragment())
                }


            })
        map.setOnClickListener {
            openActivity(MapsActivity::class.java, true)
        }
    }
}

