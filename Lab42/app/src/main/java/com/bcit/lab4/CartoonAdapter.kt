package com.bcit.lab4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


class CartoonAdapter(private val mList: List<Cartoon>) :
    RecyclerView.Adapter<CartoonAdapter.ViewHolder>() {

    // Holds the views
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView? = itemView.findViewById(R.id.imageView_recyclerView)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        holder.imageView?.setImageResource(mList[position].resourceID)
        holder.imageView?.let { RegisterViewForEvents(it, mList[position]) }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

}