package com.lookroulette.android

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.lookroulette.android.fragments.HomeFragment
import com.lookroulette.android.fragments.LooksFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var homeFragment: Fragment = HomeFragment()
    var looksFragment: Fragment = LooksFragment()
    var fm = supportFragmentManager

    var active = homeFragment

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fm.beginTransaction().hide(active).show(homeFragment).commit()
                active = homeFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_looks -> {
                fm.beginTransaction().hide(active).show(looksFragment).commit()
                active = looksFragment
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fm.beginTransaction().add(R.id.main_container, looksFragment, "looksFragment").hide(looksFragment).commit()
        fm.beginTransaction().add(R.id.main_container, homeFragment, "homeFragment").commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var id = item?.itemId

        return super.onOptionsItemSelected(item)

    }
}
