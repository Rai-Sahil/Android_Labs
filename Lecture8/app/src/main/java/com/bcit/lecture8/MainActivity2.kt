package com.bcit.lecture8

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity2 : AppCompatActivity(), OnNavigationItemSelectedListener, NavigationBarView.OnItemSelectedListener{

    lateinit var drawerLayout: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var navigationView: NavigationView
    lateinit var Bottomnav: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        drawerLayout = findViewById(R.id.drawerlayout)

        navigationView = findViewById(R.id.ItNeedsToBeLastChildInDrwaerLayoutHAVETOO)
        navigationView.setNavigationItemSelectedListener(this)

        Bottomnav = findViewById(R.id.bottom_nav)
        Bottomnav.setOnItemSelectedListener(this)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val textView : TextView = findViewById(R.id.textView_main2_linear2)
        textView.text = item.title
        return true

    }
}