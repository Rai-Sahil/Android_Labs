package com.bcit.lecture8

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<Button>(R.id.button_main_popUp).setOnClickListener{
            showPopUp(it)
        }

//        findViewById<Button>(R.id.textView_main_popup).setOnClickListener{
//            showPopUp(it)
//            //Amke it select text to dispaly
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Add menu to this activity, similar to layout inflator
        menuInflater.inflate(R.menu.bottom_navview, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println(item.title)

        if (item.itemId == android.R.id.home){
            finish()
            return true
        } else if(item.itemId == R.id.menuItem_actionbar2){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    fun showPopUp(view: View){
        val pop = PopupMenu(this, view)
        pop.setOnMenuItemClickListener(this)
        //It has own menu inflater doesn't use activity's inflater
        val menuInflater : MenuInflater = pop.menuInflater
        menuInflater.inflate(R.menu.menu_popup, pop.menu)
        pop.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        var textView : TextView = findViewById(R.id.textView_main_popup)
        textView.text = item?.title
        return true
    }
}