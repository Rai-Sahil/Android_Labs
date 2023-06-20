package com.bcit.lab4

import android.app.Activity
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class RegisterViewForEvents (view : View, var cartoon : Cartoon) : View.OnClickListener, View.OnLongClickListener{

    init{
        view.setOnClickListener(this)
        view.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        val main_activity : Activity = v?.context as Activity
        val textView = main_activity.findViewById<TextView>(R.id.textView_main)
        val editView = main_activity.findViewById<EditText>(R.id.editTextTextPersonName)
        //editView.isFocusable = false
        textView?.text = editView.text
    }


    override fun onLongClick(v: View?): Boolean {
        val main_activity : Activity = v?.context as Activity
        val imageView = main_activity.findViewById<ImageView>(R.id.imageView_main)
        imageView?.setImageResource(cartoon.resourceID)
        return true
    }
}