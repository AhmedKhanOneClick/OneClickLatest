package com.gama.task.ui.main

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.gama.task.R
import com.gama.task.databinding.ActivityMainBinding
import com.gama.task.ui.base.BaseActivity
import com.gama.task.ui.fragments.cart.CartFragment
import com.gama.task.ui.fragments.gamecards.GameCardDirections
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
        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

     //   val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment)as NavHostFragment
       // navController=navHostFragment.findNavController()
        //setupActionBarWithNavController(navController)






    }

   // override fun onSupportNavigateUp(): Boolean {
 //       return navController.navigateUp()||super.onSupportNavigateUp()
    //}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cart_btnn.setOnClickListener {
            Toast.makeText(this, "click cart", Toast.LENGTH_LONG).show()

//            findNavController(R.id.nav_host_fragment_container).currentDestination.


        // val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_host_fragment)as NavHostFragment
            //navController=navHostFragment.findNavController()
            //val toolbar = binding.toolbar
            //setSupportActionBar(toolbar)
           // setupActionBarWithNavController(navController)
            //navController.navigate(R.layout.fragment_cart)
        }
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