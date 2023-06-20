package com.bcit.lab8.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.bcit.lab8.Interface.NavigateToQuestDetailsListener
import com.bcit.lab8.Objects.Quest
import com.bcit.lab8.R


class QuestsAdapter(private val mList: List<Quest>, var goToDetailsFragment: NavigateToQuestDetailsListener) :
    RecyclerView.Adapter<QuestsAdapter.ViewHolder>() {

    // Holds the views
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val button: Button = itemView.findViewById(R.id.button_recyclerView)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_questlayout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        holder.button.text = "Quest ID -> " + mList[position].Id.toString()
        holder.button.setOnClickListener {
            goToDetailsFragment.onNavigateToQuestDetails(mList[position])
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

}