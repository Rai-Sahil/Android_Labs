package com.bcit.lec5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val ARG_PARAM1 = "param1"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        @JvmStatic
        fun mynewInstance(param1:String, param2:String){
            var frog = SpongeFragment()
            frog.arguments = Bundle()

            frog.arguments?.putString(ARG_PARAM1, param1)
        }
    }

}