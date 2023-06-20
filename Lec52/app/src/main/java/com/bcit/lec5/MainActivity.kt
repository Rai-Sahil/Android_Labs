package com.bcit.lec5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Scope Function
        /**
         *
         */

        //This thing can be written as below.
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "from non Scope Functions"

        val scope_textView = findViewById<TextView>(R.id.textView).apply {
            text = "From scope function"
        }
    }

    fun Swap (view: View){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, StarFragment.newInstance("Hello world", "hw"))
        fragmentTransaction.commit()
    }


}
