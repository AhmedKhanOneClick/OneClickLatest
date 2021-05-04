package com.gama.task.ui.main

import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.gama.task.R
import com.gama.task.databinding.ActivityMainBinding
import com.gama.task.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var drawer: DrawerLayout
    private val viewModel by viewModels<MainViewModel>()
    override fun getLayoutRes() = R.layout.activity_main
    override fun init() {
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        drawer = binding.drawerLayout
        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    @Override
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}