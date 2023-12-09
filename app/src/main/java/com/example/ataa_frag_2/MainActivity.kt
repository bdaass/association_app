package com.example.ataa_frag_2

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ataa_frag_2.databinding.ActivityMainBinding
import com.example.ataa_frag_2.ui.contact.ContactFragment
import com.example.ataa_frag_2.ui.dashboard.DashboardFragment
import com.example.ataa_frag_2.ui.home.HomeFragment
import com.example.ataa_frag_2.ui.weare.WeareFragment
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.removeItemAt


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_weare, R.id.navigation_contact
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // handle the back in the fragment issue
        navView.setOnNavigationItemReselectedListener { item ->
            if (item.itemId == R.id.navigation_dashboard) {
                val container = findViewById<ViewGroup>(R.id.pageContainer)
                supportFragmentManager.beginTransaction()
                    .replace(container.id, DashboardFragment())
                    .commit()
                container.removeAllViews()
             }
        }
    }
}

