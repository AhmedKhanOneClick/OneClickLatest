package com.gama.task.ui.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import com.gama.task.util.Localization

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity(), BaseView {


    val binding by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as DB
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        //update the localization of the activity
        Localization.updateContextLocale(this)
        super.onCreate(savedInstanceState)
        initBindingLifeCycleOwner()
        init()
    }


    override fun attachBaseContext(newBase: Context?) {
        //update the localization of the activity
        super.attachBaseContext(Localization.updateContextLocale(newBase))
    }

    override fun applyOverrideConfiguration(overrideConfiguration: Configuration?) {

        super.applyOverrideConfiguration(baseContext.resources.configuration)
    }


    override fun initBindingLifeCycleOwner() {
        binding.lifecycleOwner = this
    }

}





