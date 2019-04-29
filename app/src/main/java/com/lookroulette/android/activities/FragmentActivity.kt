package com.lookroulette.android.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.lookroulette.android.R
import com.lookroulette.android.content.LooksContent
import com.lookroulette.android.fragments.HomeFragment
import com.lookroulette.android.fragments.LooksFragment
import com.lookroulette.android.interfaces.IFragmentActivity
import kotlinx.android.synthetic.main.activity_main.*


open class FragmentActivity: BaseActivity(), IFragmentActivity, LooksFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Set Home as Default screen
        navigation.selectedItemId = R.id.navigation_home

    }

    override fun onHomeScreen() {

    }

    override fun onLooksScreen() {

    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                onHomeScreen()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_looks -> {
                onLooksScreen()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//
//        var id = item?.itemId
//
//        return super.onOptionsItemSelected(item)
//
//    }

    override fun onListFragmentInteraction(item: LooksContent.LookItem?) {

    }


}