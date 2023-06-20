package com.bcit.lab5_sahil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Declaring_frag_by_tag()

    }

    fun Declaring_frag_by_tag(){
        val fragmentManager = supportFragmentManager.beginTransaction()
        var arenaFragment = ArenaFragment()
        var homeFragment= HomeFragment()

        fragmentManager.add(R.id.fragmentContainerView_main, homeFragment, "HOMEFRAGMENT_TAG")
        fragmentManager.add(R.id.fragmentContainerView_main, arenaFragment, "ARENAFRAGMENT_TAG")
        fragmentManager.hide(arenaFragment)
        fragmentManager.commit()
    }
}