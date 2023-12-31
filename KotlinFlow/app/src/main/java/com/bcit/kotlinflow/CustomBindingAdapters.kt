package com.bcit.kotlinflow

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun loadImage(view:ImageView, url:String){
    Glide.with(view.context)
        .load(url)
        .into(view)
}