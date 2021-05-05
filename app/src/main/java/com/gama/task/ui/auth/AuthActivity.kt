package com.gama.task.ui.auth


import com.gama.task.R
import com.gama.task.databinding.ActivityAuthBinding
import com.gama.task.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>() {

    override fun getLayoutRes() = R.layout.activity_auth

    override fun init() {

    }
}