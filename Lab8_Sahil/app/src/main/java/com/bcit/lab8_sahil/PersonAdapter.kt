package com.bcit.lab8_sahil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.model.LatLng


class PersonAdapter(private val mList: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    // Holds the views
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView_people_DisplayName)
        val textView2: TextView = itemView.findViewById(R.id.textView_people_displayLocation)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        holder.textView.text = mList[position].name
        holder.textView2.text = mList[position].location
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

}