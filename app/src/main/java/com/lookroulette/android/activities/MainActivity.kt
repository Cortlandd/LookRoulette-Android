package com.lookroulette.android.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.lookroulette.android.R
import com.lookroulette.android.content.LooksContent
import com.lookroulette.android.fragments.HomeFragment
import com.lookroulette.android.fragments.LooksFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    private val FRAGMENT_HOMESCREEN_FRAG = "FRAGMENT_HOMESCREEN_FRAG"
    private val FRAGMENT_LOOKSSCREEN_FRAG = "FRAGMENT_LOOKSSCREEN_FRAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onHomeScreen() {
        super.onHomeScreen()

        val settingsFragment: HomeFragment? = supportFragmentManager.findFragmentByTag(FRAGMENT_HOMESCREEN_FRAG) as HomeFragment?
        if (settingsFragment == null) {
            supportFragmentManager.beginTransaction().replace(R.id.main_container, HomeFragment(), FRAGMENT_HOMESCREEN_FRAG).commit()
        }
    }

    override fun onLooksScreen() {
        super.onLooksScreen()

        val settingsFragment: LooksFragment? = supportFragmentManager.findFragmentByTag(FRAGMENT_LOOKSSCREEN_FRAG) as LooksFragment?
        if (settingsFragment == null) {
            supportFragmentManager.beginTransaction().replace(R.id.main_container, LooksFragment(), FRAGMENT_LOOKSSCREEN_FRAG).commit()
        }
    }

}
