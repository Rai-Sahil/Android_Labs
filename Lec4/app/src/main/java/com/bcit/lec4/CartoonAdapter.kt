package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bcit.lec4.R


class CartoonAdapter(private val mList: List<String>) :
    RecyclerView.Adapter<CartoonAdapter.ViewHolder>() {

    var onItemClick: ((String) -> Unit)? = null
    // Holds the views
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView_student)
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        holder.textView.text = mList[position]

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

}