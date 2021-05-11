package com.gama.task.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.gama.task.R
import com.gama.task.databinding.ActivityMainBinding
import com.gama.task.ui.base.BaseActivity
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

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
        //  drawer=bmainNavigationView
        //  NavigationUI.setupWithNavController(drawer,navController)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)

        toggle.syncState()
    }
//val opencart=binding.openCartBtn.setOnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drawer = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.main_navigation_view)
        navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController!!) //the second most important part

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