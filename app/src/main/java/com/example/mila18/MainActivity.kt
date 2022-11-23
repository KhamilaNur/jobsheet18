package com.example.mila18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawer: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)
        drawer = findViewById(R.id.drawer_layout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Navigation Drawer"

        toggle = ActionBarDrawerToggle(this@MainActivity, drawer, 0, 0)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_PPLG -> {
                val fragmentPplg = supportFragmentManager.beginTransaction()
                fragmentPplg.replace(R.id.content, PplgFragment())
                fragmentPplg.commit()
                drawer.closeDrawers()
            }
            R.id.nav_BUSANA -> {
                val fragmentBusana = supportFragmentManager.beginTransaction()
                fragmentBusana.replace(R.id.content, BusanaFragment())
                fragmentBusana.commit()
                drawer.closeDrawers()
            }
            R.id.nav_KULINER -> {
                val fragmentKuliner = supportFragmentManager.beginTransaction()
                fragmentKuliner.replace(R.id.content, KulinerFragment())
                fragmentKuliner.commit()
                drawer.closeDrawers()
            }

            R.id.nav_to -> {
                val fragmentTo = supportFragmentManager.beginTransaction()
                fragmentTo.replace(R.id.content, ToFragment())
                fragmentTo.commit()
                drawer.closeDrawers()
            }

            R.id.nav_tpfl-> {
                val fragmentTpfl = supportFragmentManager.beginTransaction()
                fragmentTpfl.replace(R.id.content, TpflFragment())
                fragmentTpfl.commit()
                drawer.closeDrawers()
            }
        }
        return true
    }
}